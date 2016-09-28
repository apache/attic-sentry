/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sentry.service.thrift;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;

import java.io.Closeable;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.apache.sentry.service.thrift.ServiceConstants.ServerConfig.SENTRY_HA_ENABLED;
import static org.apache.sentry.service.thrift.ServiceConstants.ServerConfig.SENTRY_HA_ENABLED_DEFAULT;

/**
 * Determines the leadership status of the Sentry daemon.
 * It handles both highly-available and non-highly-available configurations.
 */
final class LeaderStatus implements Closeable {
  private static final Log LOG = LogFactory.getLog(LeaderStatus.class);

  /**
   * Callback functions which are invoked when the leader status changes.
   */
  interface Listener {
    /**
     * Attempt to become the leader.
     *
     * @throws Exception   On error.  If an exception is thrown, we will
     *                     relinquish leadership.
     */
    void becomeActive() throws Exception;

    /**
     * Become the standby.  All exceptions thrown from this function will
     * be ignored.
     */
    void becomeStandby();
  }

  /**
   * The listener to invoke when our leadership status changes.
   */
  private final Listener listener;

  /**
   * The unique ID of this potential leader.
   */
  private final String incarnationId;

  /**
   * The LeaderStatusThread, or null if HA is disabled.
   */
  private final LeaderStatusAdaptor leaderStatusAdaptor;

  /**
   * True if this object has been closed.<p/>
   *
   * This is an AtomicBoolean so that multiple calls to close only result in one
   * close action.
   */
  private final AtomicBoolean closed = new AtomicBoolean(false);

  /**
   * Generate a 128-bit random ID.
   */
  static String generateIncarnationId() {
    SecureRandom srand = new SecureRandom();
    byte[] buf = new byte[32];
    srand.nextBytes(buf);
    return "sentry_" + Hex.encodeHexString(buf);
  }

  LeaderStatus(Listener listener, Configuration conf) throws Exception {
    this.listener = listener;
    this.incarnationId = generateIncarnationId();
    boolean isHa = conf.
      getBoolean(SENTRY_HA_ENABLED, SENTRY_HA_ENABLED_DEFAULT);
    if (isHa) {
      this.leaderStatusAdaptor = new LeaderStatusAdaptor(incarnationId, conf, listener);
    } else {
      LOG.info("LeaderStatus(incarnationId=" + incarnationId +
          "): HA is disabled.");
      this.leaderStatusAdaptor = null;
    }
  }

  public String getIncarnationId() {
    return incarnationId;
  }

  public void start() throws Exception {
    if (this.leaderStatusAdaptor != null) {
      this.leaderStatusAdaptor.start();
    } else {
      this.listener.becomeActive();
    }
  }

  @Override
  public void close() throws IOException {
    if (closed.compareAndSet(false, true)) {
      if (leaderStatusAdaptor != null) {
        // Shut down in the HA case.
        leaderStatusAdaptor.close();
      } else {
        // Shut down in the non-HA case.
        try {
          listener.becomeStandby();
        } catch (Throwable t) {
          LOG.error("becomeStandby: " + incarnationId +
              " threw an unexpected exception", t);
        }
      }
    }
  }
}
