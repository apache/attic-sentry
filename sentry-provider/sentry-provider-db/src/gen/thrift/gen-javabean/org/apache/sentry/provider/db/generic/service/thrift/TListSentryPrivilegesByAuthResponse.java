/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.sentry.provider.db.generic.service.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-04-26")
public class TListSentryPrivilegesByAuthResponse implements org.apache.thrift.TBase<TListSentryPrivilegesByAuthResponse, TListSentryPrivilegesByAuthResponse._Fields>, java.io.Serializable, Cloneable, Comparable<TListSentryPrivilegesByAuthResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TListSentryPrivilegesByAuthResponse");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PRIVILEGES_MAP_BY_AUTH_FIELD_DESC = new org.apache.thrift.protocol.TField("privilegesMapByAuth", org.apache.thrift.protocol.TType.MAP, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TListSentryPrivilegesByAuthResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TListSentryPrivilegesByAuthResponseTupleSchemeFactory());
  }

  private org.apache.sentry.service.thrift.TSentryResponseStatus status; // required
  private Map<String,TSentryPrivilegeMap> privilegesMapByAuth; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    PRIVILEGES_MAP_BY_AUTH((short)2, "privilegesMapByAuth");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // STATUS
          return STATUS;
        case 2: // PRIVILEGES_MAP_BY_AUTH
          return PRIVILEGES_MAP_BY_AUTH;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.PRIVILEGES_MAP_BY_AUTH};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, org.apache.sentry.service.thrift.TSentryResponseStatus.class)));
    tmpMap.put(_Fields.PRIVILEGES_MAP_BY_AUTH, new org.apache.thrift.meta_data.FieldMetaData("privilegesMapByAuth", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TSentryPrivilegeMap.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TListSentryPrivilegesByAuthResponse.class, metaDataMap);
  }

  public TListSentryPrivilegesByAuthResponse() {
  }

  public TListSentryPrivilegesByAuthResponse(
    org.apache.sentry.service.thrift.TSentryResponseStatus status)
  {
    this();
    this.status = status;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TListSentryPrivilegesByAuthResponse(TListSentryPrivilegesByAuthResponse other) {
    if (other.isSetStatus()) {
      this.status = new org.apache.sentry.service.thrift.TSentryResponseStatus(other.status);
    }
    if (other.isSetPrivilegesMapByAuth()) {
      Map<String,TSentryPrivilegeMap> __this__privilegesMapByAuth = new HashMap<String,TSentryPrivilegeMap>(other.privilegesMapByAuth.size());
      for (Map.Entry<String, TSentryPrivilegeMap> other_element : other.privilegesMapByAuth.entrySet()) {

        String other_element_key = other_element.getKey();
        TSentryPrivilegeMap other_element_value = other_element.getValue();

        String __this__privilegesMapByAuth_copy_key = other_element_key;

        TSentryPrivilegeMap __this__privilegesMapByAuth_copy_value = new TSentryPrivilegeMap(other_element_value);

        __this__privilegesMapByAuth.put(__this__privilegesMapByAuth_copy_key, __this__privilegesMapByAuth_copy_value);
      }
      this.privilegesMapByAuth = __this__privilegesMapByAuth;
    }
  }

  public TListSentryPrivilegesByAuthResponse deepCopy() {
    return new TListSentryPrivilegesByAuthResponse(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.privilegesMapByAuth = null;
  }

  public org.apache.sentry.service.thrift.TSentryResponseStatus getStatus() {
    return this.status;
  }

  public void setStatus(org.apache.sentry.service.thrift.TSentryResponseStatus status) {
    this.status = status;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public int getPrivilegesMapByAuthSize() {
    return (this.privilegesMapByAuth == null) ? 0 : this.privilegesMapByAuth.size();
  }

  public void putToPrivilegesMapByAuth(String key, TSentryPrivilegeMap val) {
    if (this.privilegesMapByAuth == null) {
      this.privilegesMapByAuth = new HashMap<String,TSentryPrivilegeMap>();
    }
    this.privilegesMapByAuth.put(key, val);
  }

  public Map<String,TSentryPrivilegeMap> getPrivilegesMapByAuth() {
    return this.privilegesMapByAuth;
  }

  public void setPrivilegesMapByAuth(Map<String,TSentryPrivilegeMap> privilegesMapByAuth) {
    this.privilegesMapByAuth = privilegesMapByAuth;
  }

  public void unsetPrivilegesMapByAuth() {
    this.privilegesMapByAuth = null;
  }

  /** Returns true if field privilegesMapByAuth is set (has been assigned a value) and false otherwise */
  public boolean isSetPrivilegesMapByAuth() {
    return this.privilegesMapByAuth != null;
  }

  public void setPrivilegesMapByAuthIsSet(boolean value) {
    if (!value) {
      this.privilegesMapByAuth = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((org.apache.sentry.service.thrift.TSentryResponseStatus)value);
      }
      break;

    case PRIVILEGES_MAP_BY_AUTH:
      if (value == null) {
        unsetPrivilegesMapByAuth();
      } else {
        setPrivilegesMapByAuth((Map<String,TSentryPrivilegeMap>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case PRIVILEGES_MAP_BY_AUTH:
      return getPrivilegesMapByAuth();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case PRIVILEGES_MAP_BY_AUTH:
      return isSetPrivilegesMapByAuth();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TListSentryPrivilegesByAuthResponse)
      return this.equals((TListSentryPrivilegesByAuthResponse)that);
    return false;
  }

  public boolean equals(TListSentryPrivilegesByAuthResponse that) {
    if (that == null)
      return false;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_privilegesMapByAuth = true && this.isSetPrivilegesMapByAuth();
    boolean that_present_privilegesMapByAuth = true && that.isSetPrivilegesMapByAuth();
    if (this_present_privilegesMapByAuth || that_present_privilegesMapByAuth) {
      if (!(this_present_privilegesMapByAuth && that_present_privilegesMapByAuth))
        return false;
      if (!this.privilegesMapByAuth.equals(that.privilegesMapByAuth))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_status = true && (isSetStatus());
    list.add(present_status);
    if (present_status)
      list.add(status);

    boolean present_privilegesMapByAuth = true && (isSetPrivilegesMapByAuth());
    list.add(present_privilegesMapByAuth);
    if (present_privilegesMapByAuth)
      list.add(privilegesMapByAuth);

    return list.hashCode();
  }

  @Override
  public int compareTo(TListSentryPrivilegesByAuthResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrivilegesMapByAuth()).compareTo(other.isSetPrivilegesMapByAuth());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrivilegesMapByAuth()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.privilegesMapByAuth, other.privilegesMapByAuth);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TListSentryPrivilegesByAuthResponse(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (isSetPrivilegesMapByAuth()) {
      if (!first) sb.append(", ");
      sb.append("privilegesMapByAuth:");
      if (this.privilegesMapByAuth == null) {
        sb.append("null");
      } else {
        sb.append(this.privilegesMapByAuth);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetStatus()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
    if (status != null) {
      status.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TListSentryPrivilegesByAuthResponseStandardSchemeFactory implements SchemeFactory {
    public TListSentryPrivilegesByAuthResponseStandardScheme getScheme() {
      return new TListSentryPrivilegesByAuthResponseStandardScheme();
    }
  }

  private static class TListSentryPrivilegesByAuthResponseStandardScheme extends StandardScheme<TListSentryPrivilegesByAuthResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TListSentryPrivilegesByAuthResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.status = new org.apache.sentry.service.thrift.TSentryResponseStatus();
              struct.status.read(iprot);
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PRIVILEGES_MAP_BY_AUTH
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map138 = iprot.readMapBegin();
                struct.privilegesMapByAuth = new HashMap<String,TSentryPrivilegeMap>(2*_map138.size);
                String _key139;
                TSentryPrivilegeMap _val140;
                for (int _i141 = 0; _i141 < _map138.size; ++_i141)
                {
                  _key139 = iprot.readString();
                  _val140 = new TSentryPrivilegeMap();
                  _val140.read(iprot);
                  struct.privilegesMapByAuth.put(_key139, _val140);
                }
                iprot.readMapEnd();
              }
              struct.setPrivilegesMapByAuthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TListSentryPrivilegesByAuthResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        struct.status.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.privilegesMapByAuth != null) {
        if (struct.isSetPrivilegesMapByAuth()) {
          oprot.writeFieldBegin(PRIVILEGES_MAP_BY_AUTH_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, struct.privilegesMapByAuth.size()));
            for (Map.Entry<String, TSentryPrivilegeMap> _iter142 : struct.privilegesMapByAuth.entrySet())
            {
              oprot.writeString(_iter142.getKey());
              _iter142.getValue().write(oprot);
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TListSentryPrivilegesByAuthResponseTupleSchemeFactory implements SchemeFactory {
    public TListSentryPrivilegesByAuthResponseTupleScheme getScheme() {
      return new TListSentryPrivilegesByAuthResponseTupleScheme();
    }
  }

  private static class TListSentryPrivilegesByAuthResponseTupleScheme extends TupleScheme<TListSentryPrivilegesByAuthResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TListSentryPrivilegesByAuthResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      struct.status.write(oprot);
      BitSet optionals = new BitSet();
      if (struct.isSetPrivilegesMapByAuth()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetPrivilegesMapByAuth()) {
        {
          oprot.writeI32(struct.privilegesMapByAuth.size());
          for (Map.Entry<String, TSentryPrivilegeMap> _iter143 : struct.privilegesMapByAuth.entrySet())
          {
            oprot.writeString(_iter143.getKey());
            _iter143.getValue().write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TListSentryPrivilegesByAuthResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.status = new org.apache.sentry.service.thrift.TSentryResponseStatus();
      struct.status.read(iprot);
      struct.setStatusIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map144 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.privilegesMapByAuth = new HashMap<String,TSentryPrivilegeMap>(2*_map144.size);
          String _key145;
          TSentryPrivilegeMap _val146;
          for (int _i147 = 0; _i147 < _map144.size; ++_i147)
          {
            _key145 = iprot.readString();
            _val146 = new TSentryPrivilegeMap();
            _val146.read(iprot);
            struct.privilegesMapByAuth.put(_key145, _val146);
          }
        }
        struct.setPrivilegesMapByAuthIsSet(true);
      }
    }
  }

}

