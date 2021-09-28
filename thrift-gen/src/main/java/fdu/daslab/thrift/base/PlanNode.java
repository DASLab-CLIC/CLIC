/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package fdu.daslab.thrift.base;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2021-09-28")
public class PlanNode implements org.apache.thrift.TBase<PlanNode, PlanNode._Fields>, java.io.Serializable, Cloneable, Comparable<PlanNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PlanNode");

  private static final org.apache.thrift.protocol.TField NODE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("nodeId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField OPERATOR_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("operatorInfo", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField INPUT_NODE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("inputNodeId", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField OUTPUT_NODE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("outputNodeId", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField PLATFORM_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("platformName", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PlanNodeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PlanNodeTupleSchemeFactory();

  public int nodeId; // required
  public @org.apache.thrift.annotation.Nullable Operator operatorInfo; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> inputNodeId; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> outputNodeId; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String platformName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NODE_ID((short)1, "nodeId"),
    OPERATOR_INFO((short)2, "operatorInfo"),
    INPUT_NODE_ID((short)3, "inputNodeId"),
    OUTPUT_NODE_ID((short)4, "outputNodeId"),
    PLATFORM_NAME((short)5, "platformName");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NODE_ID
          return NODE_ID;
        case 2: // OPERATOR_INFO
          return OPERATOR_INFO;
        case 3: // INPUT_NODE_ID
          return INPUT_NODE_ID;
        case 4: // OUTPUT_NODE_ID
          return OUTPUT_NODE_ID;
        case 5: // PLATFORM_NAME
          return PLATFORM_NAME;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __NODEID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NODE_ID, new org.apache.thrift.meta_data.FieldMetaData("nodeId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.OPERATOR_INFO, new org.apache.thrift.meta_data.FieldMetaData("operatorInfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Operator.class)));
    tmpMap.put(_Fields.INPUT_NODE_ID, new org.apache.thrift.meta_data.FieldMetaData("inputNodeId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.OUTPUT_NODE_ID, new org.apache.thrift.meta_data.FieldMetaData("outputNodeId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.PLATFORM_NAME, new org.apache.thrift.meta_data.FieldMetaData("platformName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PlanNode.class, metaDataMap);
  }

  public PlanNode() {
    this.inputNodeId = new java.util.ArrayList<java.lang.Integer>();

    this.outputNodeId = new java.util.ArrayList<java.lang.Integer>();

  }

  public PlanNode(
    int nodeId,
    Operator operatorInfo,
    java.util.List<java.lang.Integer> inputNodeId,
    java.util.List<java.lang.Integer> outputNodeId,
    java.lang.String platformName)
  {
    this();
    this.nodeId = nodeId;
    setNodeIdIsSet(true);
    this.operatorInfo = operatorInfo;
    this.inputNodeId = inputNodeId;
    this.outputNodeId = outputNodeId;
    this.platformName = platformName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PlanNode(PlanNode other) {
    __isset_bitfield = other.__isset_bitfield;
    this.nodeId = other.nodeId;
    if (other.isSetOperatorInfo()) {
      this.operatorInfo = new Operator(other.operatorInfo);
    }
    if (other.isSetInputNodeId()) {
      java.util.List<java.lang.Integer> __this__inputNodeId = new java.util.ArrayList<java.lang.Integer>(other.inputNodeId);
      this.inputNodeId = __this__inputNodeId;
    }
    if (other.isSetOutputNodeId()) {
      java.util.List<java.lang.Integer> __this__outputNodeId = new java.util.ArrayList<java.lang.Integer>(other.outputNodeId);
      this.outputNodeId = __this__outputNodeId;
    }
    if (other.isSetPlatformName()) {
      this.platformName = other.platformName;
    }
  }

  public PlanNode deepCopy() {
    return new PlanNode(this);
  }

  @Override
  public void clear() {
    setNodeIdIsSet(false);
    this.nodeId = 0;
    this.operatorInfo = null;
    this.inputNodeId = new java.util.ArrayList<java.lang.Integer>();

    this.outputNodeId = new java.util.ArrayList<java.lang.Integer>();

    this.platformName = null;
  }

  public int getNodeId() {
    return this.nodeId;
  }

  public PlanNode setNodeId(int nodeId) {
    this.nodeId = nodeId;
    setNodeIdIsSet(true);
    return this;
  }

  public void unsetNodeId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NODEID_ISSET_ID);
  }

  /** Returns true if field nodeId is set (has been assigned a value) and false otherwise */
  public boolean isSetNodeId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NODEID_ISSET_ID);
  }

  public void setNodeIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NODEID_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public Operator getOperatorInfo() {
    return this.operatorInfo;
  }

  public PlanNode setOperatorInfo(@org.apache.thrift.annotation.Nullable Operator operatorInfo) {
    this.operatorInfo = operatorInfo;
    return this;
  }

  public void unsetOperatorInfo() {
    this.operatorInfo = null;
  }

  /** Returns true if field operatorInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetOperatorInfo() {
    return this.operatorInfo != null;
  }

  public void setOperatorInfoIsSet(boolean value) {
    if (!value) {
      this.operatorInfo = null;
    }
  }

  public int getInputNodeIdSize() {
    return (this.inputNodeId == null) ? 0 : this.inputNodeId.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getInputNodeIdIterator() {
    return (this.inputNodeId == null) ? null : this.inputNodeId.iterator();
  }

  public void addToInputNodeId(int elem) {
    if (this.inputNodeId == null) {
      this.inputNodeId = new java.util.ArrayList<java.lang.Integer>();
    }
    this.inputNodeId.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getInputNodeId() {
    return this.inputNodeId;
  }

  public PlanNode setInputNodeId(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> inputNodeId) {
    this.inputNodeId = inputNodeId;
    return this;
  }

  public void unsetInputNodeId() {
    this.inputNodeId = null;
  }

  /** Returns true if field inputNodeId is set (has been assigned a value) and false otherwise */
  public boolean isSetInputNodeId() {
    return this.inputNodeId != null;
  }

  public void setInputNodeIdIsSet(boolean value) {
    if (!value) {
      this.inputNodeId = null;
    }
  }

  public int getOutputNodeIdSize() {
    return (this.outputNodeId == null) ? 0 : this.outputNodeId.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getOutputNodeIdIterator() {
    return (this.outputNodeId == null) ? null : this.outputNodeId.iterator();
  }

  public void addToOutputNodeId(int elem) {
    if (this.outputNodeId == null) {
      this.outputNodeId = new java.util.ArrayList<java.lang.Integer>();
    }
    this.outputNodeId.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getOutputNodeId() {
    return this.outputNodeId;
  }

  public PlanNode setOutputNodeId(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> outputNodeId) {
    this.outputNodeId = outputNodeId;
    return this;
  }

  public void unsetOutputNodeId() {
    this.outputNodeId = null;
  }

  /** Returns true if field outputNodeId is set (has been assigned a value) and false otherwise */
  public boolean isSetOutputNodeId() {
    return this.outputNodeId != null;
  }

  public void setOutputNodeIdIsSet(boolean value) {
    if (!value) {
      this.outputNodeId = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPlatformName() {
    return this.platformName;
  }

  public PlanNode setPlatformName(@org.apache.thrift.annotation.Nullable java.lang.String platformName) {
    this.platformName = platformName;
    return this;
  }

  public void unsetPlatformName() {
    this.platformName = null;
  }

  /** Returns true if field platformName is set (has been assigned a value) and false otherwise */
  public boolean isSetPlatformName() {
    return this.platformName != null;
  }

  public void setPlatformNameIsSet(boolean value) {
    if (!value) {
      this.platformName = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NODE_ID:
      if (value == null) {
        unsetNodeId();
      } else {
        setNodeId((java.lang.Integer)value);
      }
      break;

    case OPERATOR_INFO:
      if (value == null) {
        unsetOperatorInfo();
      } else {
        setOperatorInfo((Operator)value);
      }
      break;

    case INPUT_NODE_ID:
      if (value == null) {
        unsetInputNodeId();
      } else {
        setInputNodeId((java.util.List<java.lang.Integer>)value);
      }
      break;

    case OUTPUT_NODE_ID:
      if (value == null) {
        unsetOutputNodeId();
      } else {
        setOutputNodeId((java.util.List<java.lang.Integer>)value);
      }
      break;

    case PLATFORM_NAME:
      if (value == null) {
        unsetPlatformName();
      } else {
        setPlatformName((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NODE_ID:
      return getNodeId();

    case OPERATOR_INFO:
      return getOperatorInfo();

    case INPUT_NODE_ID:
      return getInputNodeId();

    case OUTPUT_NODE_ID:
      return getOutputNodeId();

    case PLATFORM_NAME:
      return getPlatformName();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NODE_ID:
      return isSetNodeId();
    case OPERATOR_INFO:
      return isSetOperatorInfo();
    case INPUT_NODE_ID:
      return isSetInputNodeId();
    case OUTPUT_NODE_ID:
      return isSetOutputNodeId();
    case PLATFORM_NAME:
      return isSetPlatformName();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof PlanNode)
      return this.equals((PlanNode)that);
    return false;
  }

  public boolean equals(PlanNode that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_nodeId = true;
    boolean that_present_nodeId = true;
    if (this_present_nodeId || that_present_nodeId) {
      if (!(this_present_nodeId && that_present_nodeId))
        return false;
      if (this.nodeId != that.nodeId)
        return false;
    }

    boolean this_present_operatorInfo = true && this.isSetOperatorInfo();
    boolean that_present_operatorInfo = true && that.isSetOperatorInfo();
    if (this_present_operatorInfo || that_present_operatorInfo) {
      if (!(this_present_operatorInfo && that_present_operatorInfo))
        return false;
      if (!this.operatorInfo.equals(that.operatorInfo))
        return false;
    }

    boolean this_present_inputNodeId = true && this.isSetInputNodeId();
    boolean that_present_inputNodeId = true && that.isSetInputNodeId();
    if (this_present_inputNodeId || that_present_inputNodeId) {
      if (!(this_present_inputNodeId && that_present_inputNodeId))
        return false;
      if (!this.inputNodeId.equals(that.inputNodeId))
        return false;
    }

    boolean this_present_outputNodeId = true && this.isSetOutputNodeId();
    boolean that_present_outputNodeId = true && that.isSetOutputNodeId();
    if (this_present_outputNodeId || that_present_outputNodeId) {
      if (!(this_present_outputNodeId && that_present_outputNodeId))
        return false;
      if (!this.outputNodeId.equals(that.outputNodeId))
        return false;
    }

    boolean this_present_platformName = true && this.isSetPlatformName();
    boolean that_present_platformName = true && that.isSetPlatformName();
    if (this_present_platformName || that_present_platformName) {
      if (!(this_present_platformName && that_present_platformName))
        return false;
      if (!this.platformName.equals(that.platformName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + nodeId;

    hashCode = hashCode * 8191 + ((isSetOperatorInfo()) ? 131071 : 524287);
    if (isSetOperatorInfo())
      hashCode = hashCode * 8191 + operatorInfo.hashCode();

    hashCode = hashCode * 8191 + ((isSetInputNodeId()) ? 131071 : 524287);
    if (isSetInputNodeId())
      hashCode = hashCode * 8191 + inputNodeId.hashCode();

    hashCode = hashCode * 8191 + ((isSetOutputNodeId()) ? 131071 : 524287);
    if (isSetOutputNodeId())
      hashCode = hashCode * 8191 + outputNodeId.hashCode();

    hashCode = hashCode * 8191 + ((isSetPlatformName()) ? 131071 : 524287);
    if (isSetPlatformName())
      hashCode = hashCode * 8191 + platformName.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(PlanNode other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetNodeId()).compareTo(other.isSetNodeId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNodeId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nodeId, other.nodeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetOperatorInfo()).compareTo(other.isSetOperatorInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOperatorInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.operatorInfo, other.operatorInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetInputNodeId()).compareTo(other.isSetInputNodeId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInputNodeId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.inputNodeId, other.inputNodeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetOutputNodeId()).compareTo(other.isSetOutputNodeId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOutputNodeId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.outputNodeId, other.outputNodeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPlatformName()).compareTo(other.isSetPlatformName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlatformName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.platformName, other.platformName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("PlanNode(");
    boolean first = true;

    sb.append("nodeId:");
    sb.append(this.nodeId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("operatorInfo:");
    if (this.operatorInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.operatorInfo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("inputNodeId:");
    if (this.inputNodeId == null) {
      sb.append("null");
    } else {
      sb.append(this.inputNodeId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("outputNodeId:");
    if (this.outputNodeId == null) {
      sb.append("null");
    } else {
      sb.append(this.outputNodeId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("platformName:");
    if (this.platformName == null) {
      sb.append("null");
    } else {
      sb.append(this.platformName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (operatorInfo != null) {
      operatorInfo.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PlanNodeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PlanNodeStandardScheme getScheme() {
      return new PlanNodeStandardScheme();
    }
  }

  private static class PlanNodeStandardScheme extends org.apache.thrift.scheme.StandardScheme<PlanNode> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PlanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NODE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.nodeId = iprot.readI32();
              struct.setNodeIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // OPERATOR_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.operatorInfo = new Operator();
              struct.operatorInfo.read(iprot);
              struct.setOperatorInfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // INPUT_NODE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list44 = iprot.readListBegin();
                struct.inputNodeId = new java.util.ArrayList<java.lang.Integer>(_list44.size);
                int _elem45;
                for (int _i46 = 0; _i46 < _list44.size; ++_i46)
                {
                  _elem45 = iprot.readI32();
                  struct.inputNodeId.add(_elem45);
                }
                iprot.readListEnd();
              }
              struct.setInputNodeIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // OUTPUT_NODE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list47 = iprot.readListBegin();
                struct.outputNodeId = new java.util.ArrayList<java.lang.Integer>(_list47.size);
                int _elem48;
                for (int _i49 = 0; _i49 < _list47.size; ++_i49)
                {
                  _elem48 = iprot.readI32();
                  struct.outputNodeId.add(_elem48);
                }
                iprot.readListEnd();
              }
              struct.setOutputNodeIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PLATFORM_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.platformName = iprot.readString();
              struct.setPlatformNameIsSet(true);
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

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, PlanNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(NODE_ID_FIELD_DESC);
      oprot.writeI32(struct.nodeId);
      oprot.writeFieldEnd();
      if (struct.operatorInfo != null) {
        oprot.writeFieldBegin(OPERATOR_INFO_FIELD_DESC);
        struct.operatorInfo.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.inputNodeId != null) {
        oprot.writeFieldBegin(INPUT_NODE_ID_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.inputNodeId.size()));
          for (int _iter50 : struct.inputNodeId)
          {
            oprot.writeI32(_iter50);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.outputNodeId != null) {
        oprot.writeFieldBegin(OUTPUT_NODE_ID_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.outputNodeId.size()));
          for (int _iter51 : struct.outputNodeId)
          {
            oprot.writeI32(_iter51);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.platformName != null) {
        oprot.writeFieldBegin(PLATFORM_NAME_FIELD_DESC);
        oprot.writeString(struct.platformName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PlanNodeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PlanNodeTupleScheme getScheme() {
      return new PlanNodeTupleScheme();
    }
  }

  private static class PlanNodeTupleScheme extends org.apache.thrift.scheme.TupleScheme<PlanNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PlanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetNodeId()) {
        optionals.set(0);
      }
      if (struct.isSetOperatorInfo()) {
        optionals.set(1);
      }
      if (struct.isSetInputNodeId()) {
        optionals.set(2);
      }
      if (struct.isSetOutputNodeId()) {
        optionals.set(3);
      }
      if (struct.isSetPlatformName()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetNodeId()) {
        oprot.writeI32(struct.nodeId);
      }
      if (struct.isSetOperatorInfo()) {
        struct.operatorInfo.write(oprot);
      }
      if (struct.isSetInputNodeId()) {
        {
          oprot.writeI32(struct.inputNodeId.size());
          for (int _iter52 : struct.inputNodeId)
          {
            oprot.writeI32(_iter52);
          }
        }
      }
      if (struct.isSetOutputNodeId()) {
        {
          oprot.writeI32(struct.outputNodeId.size());
          for (int _iter53 : struct.outputNodeId)
          {
            oprot.writeI32(_iter53);
          }
        }
      }
      if (struct.isSetPlatformName()) {
        oprot.writeString(struct.platformName);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PlanNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.nodeId = iprot.readI32();
        struct.setNodeIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.operatorInfo = new Operator();
        struct.operatorInfo.read(iprot);
        struct.setOperatorInfoIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list54 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.inputNodeId = new java.util.ArrayList<java.lang.Integer>(_list54.size);
          int _elem55;
          for (int _i56 = 0; _i56 < _list54.size; ++_i56)
          {
            _elem55 = iprot.readI32();
            struct.inputNodeId.add(_elem55);
          }
        }
        struct.setInputNodeIdIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list57 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.outputNodeId = new java.util.ArrayList<java.lang.Integer>(_list57.size);
          int _elem58;
          for (int _i59 = 0; _i59 < _list57.size; ++_i59)
          {
            _elem58 = iprot.readI32();
            struct.outputNodeId.add(_elem58);
          }
        }
        struct.setOutputNodeIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.platformName = iprot.readString();
        struct.setPlatformNameIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

