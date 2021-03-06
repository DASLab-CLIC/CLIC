/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package fdu.daslab.thrift.base;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2021-10-11")
public class Plan implements org.apache.thrift.TBase<Plan, Plan._Fields>, java.io.Serializable, Cloneable, Comparable<Plan> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Plan");

  private static final org.apache.thrift.protocol.TField NODES_FIELD_DESC = new org.apache.thrift.protocol.TField("nodes", org.apache.thrift.protocol.TType.MAP, (short)1);
  private static final org.apache.thrift.protocol.TField SOURCE_NODES_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceNodes", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField SINK_NODES_FIELD_DESC = new org.apache.thrift.protocol.TField("sinkNodes", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField OTHERS_FIELD_DESC = new org.apache.thrift.protocol.TField("others", org.apache.thrift.protocol.TType.MAP, (short)16);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PlanStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PlanTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Integer,PlanNode> nodes; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> sourceNodes; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> sinkNodes; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> others; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NODES((short)1, "nodes"),
    SOURCE_NODES((short)2, "sourceNodes"),
    SINK_NODES((short)3, "sinkNodes"),
    OTHERS((short)16, "others");

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
        case 1: // NODES
          return NODES;
        case 2: // SOURCE_NODES
          return SOURCE_NODES;
        case 3: // SINK_NODES
          return SINK_NODES;
        case 16: // OTHERS
          return OTHERS;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NODES, new org.apache.thrift.meta_data.FieldMetaData("nodes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PlanNode.class))));
    tmpMap.put(_Fields.SOURCE_NODES, new org.apache.thrift.meta_data.FieldMetaData("sourceNodes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.SINK_NODES, new org.apache.thrift.meta_data.FieldMetaData("sinkNodes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.OTHERS, new org.apache.thrift.meta_data.FieldMetaData("others", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Plan.class, metaDataMap);
  }

  public Plan() {
    this.nodes = new java.util.HashMap<java.lang.Integer,PlanNode>();

    this.sourceNodes = new java.util.ArrayList<java.lang.Integer>();

    this.sinkNodes = new java.util.ArrayList<java.lang.Integer>();

    this.others = new java.util.HashMap<java.lang.String,java.lang.String>();

  }

  public Plan(
    java.util.Map<java.lang.Integer,PlanNode> nodes,
    java.util.List<java.lang.Integer> sourceNodes,
    java.util.List<java.lang.Integer> sinkNodes,
    java.util.Map<java.lang.String,java.lang.String> others)
  {
    this();
    this.nodes = nodes;
    this.sourceNodes = sourceNodes;
    this.sinkNodes = sinkNodes;
    this.others = others;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Plan(Plan other) {
    if (other.isSetNodes()) {
      java.util.Map<java.lang.Integer,PlanNode> __this__nodes = new java.util.HashMap<java.lang.Integer,PlanNode>(other.nodes.size());
      for (java.util.Map.Entry<java.lang.Integer, PlanNode> other_element : other.nodes.entrySet()) {

        java.lang.Integer other_element_key = other_element.getKey();
        PlanNode other_element_value = other_element.getValue();

        java.lang.Integer __this__nodes_copy_key = other_element_key;

        PlanNode __this__nodes_copy_value = new PlanNode(other_element_value);

        __this__nodes.put(__this__nodes_copy_key, __this__nodes_copy_value);
      }
      this.nodes = __this__nodes;
    }
    if (other.isSetSourceNodes()) {
      java.util.List<java.lang.Integer> __this__sourceNodes = new java.util.ArrayList<java.lang.Integer>(other.sourceNodes);
      this.sourceNodes = __this__sourceNodes;
    }
    if (other.isSetSinkNodes()) {
      java.util.List<java.lang.Integer> __this__sinkNodes = new java.util.ArrayList<java.lang.Integer>(other.sinkNodes);
      this.sinkNodes = __this__sinkNodes;
    }
    if (other.isSetOthers()) {
      java.util.Map<java.lang.String,java.lang.String> __this__others = new java.util.HashMap<java.lang.String,java.lang.String>(other.others);
      this.others = __this__others;
    }
  }

  public Plan deepCopy() {
    return new Plan(this);
  }

  @Override
  public void clear() {
    this.nodes = new java.util.HashMap<java.lang.Integer,PlanNode>();

    this.sourceNodes = new java.util.ArrayList<java.lang.Integer>();

    this.sinkNodes = new java.util.ArrayList<java.lang.Integer>();

    this.others = new java.util.HashMap<java.lang.String,java.lang.String>();

  }

  public int getNodesSize() {
    return (this.nodes == null) ? 0 : this.nodes.size();
  }

  public void putToNodes(int key, PlanNode val) {
    if (this.nodes == null) {
      this.nodes = new java.util.HashMap<java.lang.Integer,PlanNode>();
    }
    this.nodes.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.Integer,PlanNode> getNodes() {
    return this.nodes;
  }

  public Plan setNodes(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.Integer,PlanNode> nodes) {
    this.nodes = nodes;
    return this;
  }

  public void unsetNodes() {
    this.nodes = null;
  }

  /** Returns true if field nodes is set (has been assigned a value) and false otherwise */
  public boolean isSetNodes() {
    return this.nodes != null;
  }

  public void setNodesIsSet(boolean value) {
    if (!value) {
      this.nodes = null;
    }
  }

  public int getSourceNodesSize() {
    return (this.sourceNodes == null) ? 0 : this.sourceNodes.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getSourceNodesIterator() {
    return (this.sourceNodes == null) ? null : this.sourceNodes.iterator();
  }

  public void addToSourceNodes(int elem) {
    if (this.sourceNodes == null) {
      this.sourceNodes = new java.util.ArrayList<java.lang.Integer>();
    }
    this.sourceNodes.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getSourceNodes() {
    return this.sourceNodes;
  }

  public Plan setSourceNodes(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> sourceNodes) {
    this.sourceNodes = sourceNodes;
    return this;
  }

  public void unsetSourceNodes() {
    this.sourceNodes = null;
  }

  /** Returns true if field sourceNodes is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceNodes() {
    return this.sourceNodes != null;
  }

  public void setSourceNodesIsSet(boolean value) {
    if (!value) {
      this.sourceNodes = null;
    }
  }

  public int getSinkNodesSize() {
    return (this.sinkNodes == null) ? 0 : this.sinkNodes.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getSinkNodesIterator() {
    return (this.sinkNodes == null) ? null : this.sinkNodes.iterator();
  }

  public void addToSinkNodes(int elem) {
    if (this.sinkNodes == null) {
      this.sinkNodes = new java.util.ArrayList<java.lang.Integer>();
    }
    this.sinkNodes.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getSinkNodes() {
    return this.sinkNodes;
  }

  public Plan setSinkNodes(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> sinkNodes) {
    this.sinkNodes = sinkNodes;
    return this;
  }

  public void unsetSinkNodes() {
    this.sinkNodes = null;
  }

  /** Returns true if field sinkNodes is set (has been assigned a value) and false otherwise */
  public boolean isSetSinkNodes() {
    return this.sinkNodes != null;
  }

  public void setSinkNodesIsSet(boolean value) {
    if (!value) {
      this.sinkNodes = null;
    }
  }

  public int getOthersSize() {
    return (this.others == null) ? 0 : this.others.size();
  }

  public void putToOthers(java.lang.String key, java.lang.String val) {
    if (this.others == null) {
      this.others = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.others.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getOthers() {
    return this.others;
  }

  public Plan setOthers(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> others) {
    this.others = others;
    return this;
  }

  public void unsetOthers() {
    this.others = null;
  }

  /** Returns true if field others is set (has been assigned a value) and false otherwise */
  public boolean isSetOthers() {
    return this.others != null;
  }

  public void setOthersIsSet(boolean value) {
    if (!value) {
      this.others = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NODES:
      if (value == null) {
        unsetNodes();
      } else {
        setNodes((java.util.Map<java.lang.Integer,PlanNode>)value);
      }
      break;

    case SOURCE_NODES:
      if (value == null) {
        unsetSourceNodes();
      } else {
        setSourceNodes((java.util.List<java.lang.Integer>)value);
      }
      break;

    case SINK_NODES:
      if (value == null) {
        unsetSinkNodes();
      } else {
        setSinkNodes((java.util.List<java.lang.Integer>)value);
      }
      break;

    case OTHERS:
      if (value == null) {
        unsetOthers();
      } else {
        setOthers((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NODES:
      return getNodes();

    case SOURCE_NODES:
      return getSourceNodes();

    case SINK_NODES:
      return getSinkNodes();

    case OTHERS:
      return getOthers();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NODES:
      return isSetNodes();
    case SOURCE_NODES:
      return isSetSourceNodes();
    case SINK_NODES:
      return isSetSinkNodes();
    case OTHERS:
      return isSetOthers();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Plan)
      return this.equals((Plan)that);
    return false;
  }

  public boolean equals(Plan that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_nodes = true && this.isSetNodes();
    boolean that_present_nodes = true && that.isSetNodes();
    if (this_present_nodes || that_present_nodes) {
      if (!(this_present_nodes && that_present_nodes))
        return false;
      if (!this.nodes.equals(that.nodes))
        return false;
    }

    boolean this_present_sourceNodes = true && this.isSetSourceNodes();
    boolean that_present_sourceNodes = true && that.isSetSourceNodes();
    if (this_present_sourceNodes || that_present_sourceNodes) {
      if (!(this_present_sourceNodes && that_present_sourceNodes))
        return false;
      if (!this.sourceNodes.equals(that.sourceNodes))
        return false;
    }

    boolean this_present_sinkNodes = true && this.isSetSinkNodes();
    boolean that_present_sinkNodes = true && that.isSetSinkNodes();
    if (this_present_sinkNodes || that_present_sinkNodes) {
      if (!(this_present_sinkNodes && that_present_sinkNodes))
        return false;
      if (!this.sinkNodes.equals(that.sinkNodes))
        return false;
    }

    boolean this_present_others = true && this.isSetOthers();
    boolean that_present_others = true && that.isSetOthers();
    if (this_present_others || that_present_others) {
      if (!(this_present_others && that_present_others))
        return false;
      if (!this.others.equals(that.others))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetNodes()) ? 131071 : 524287);
    if (isSetNodes())
      hashCode = hashCode * 8191 + nodes.hashCode();

    hashCode = hashCode * 8191 + ((isSetSourceNodes()) ? 131071 : 524287);
    if (isSetSourceNodes())
      hashCode = hashCode * 8191 + sourceNodes.hashCode();

    hashCode = hashCode * 8191 + ((isSetSinkNodes()) ? 131071 : 524287);
    if (isSetSinkNodes())
      hashCode = hashCode * 8191 + sinkNodes.hashCode();

    hashCode = hashCode * 8191 + ((isSetOthers()) ? 131071 : 524287);
    if (isSetOthers())
      hashCode = hashCode * 8191 + others.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Plan other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetNodes()).compareTo(other.isSetNodes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNodes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nodes, other.nodes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetSourceNodes()).compareTo(other.isSetSourceNodes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceNodes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceNodes, other.sourceNodes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetSinkNodes()).compareTo(other.isSetSinkNodes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSinkNodes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sinkNodes, other.sinkNodes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetOthers()).compareTo(other.isSetOthers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOthers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.others, other.others);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Plan(");
    boolean first = true;

    sb.append("nodes:");
    if (this.nodes == null) {
      sb.append("null");
    } else {
      sb.append(this.nodes);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sourceNodes:");
    if (this.sourceNodes == null) {
      sb.append("null");
    } else {
      sb.append(this.sourceNodes);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sinkNodes:");
    if (this.sinkNodes == null) {
      sb.append("null");
    } else {
      sb.append(this.sinkNodes);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("others:");
    if (this.others == null) {
      sb.append("null");
    } else {
      sb.append(this.others);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PlanStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PlanStandardScheme getScheme() {
      return new PlanStandardScheme();
    }
  }

  private static class PlanStandardScheme extends org.apache.thrift.scheme.StandardScheme<Plan> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Plan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NODES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map60 = iprot.readMapBegin();
                struct.nodes = new java.util.HashMap<java.lang.Integer,PlanNode>(2*_map60.size);
                int _key61;
                @org.apache.thrift.annotation.Nullable PlanNode _val62;
                for (int _i63 = 0; _i63 < _map60.size; ++_i63)
                {
                  _key61 = iprot.readI32();
                  _val62 = new PlanNode();
                  _val62.read(iprot);
                  struct.nodes.put(_key61, _val62);
                }
                iprot.readMapEnd();
              }
              struct.setNodesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SOURCE_NODES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list64 = iprot.readListBegin();
                struct.sourceNodes = new java.util.ArrayList<java.lang.Integer>(_list64.size);
                int _elem65;
                for (int _i66 = 0; _i66 < _list64.size; ++_i66)
                {
                  _elem65 = iprot.readI32();
                  struct.sourceNodes.add(_elem65);
                }
                iprot.readListEnd();
              }
              struct.setSourceNodesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SINK_NODES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list67 = iprot.readListBegin();
                struct.sinkNodes = new java.util.ArrayList<java.lang.Integer>(_list67.size);
                int _elem68;
                for (int _i69 = 0; _i69 < _list67.size; ++_i69)
                {
                  _elem68 = iprot.readI32();
                  struct.sinkNodes.add(_elem68);
                }
                iprot.readListEnd();
              }
              struct.setSinkNodesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 16: // OTHERS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map70 = iprot.readMapBegin();
                struct.others = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map70.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key71;
                @org.apache.thrift.annotation.Nullable java.lang.String _val72;
                for (int _i73 = 0; _i73 < _map70.size; ++_i73)
                {
                  _key71 = iprot.readString();
                  _val72 = iprot.readString();
                  struct.others.put(_key71, _val72);
                }
                iprot.readMapEnd();
              }
              struct.setOthersIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Plan struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.nodes != null) {
        oprot.writeFieldBegin(NODES_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRUCT, struct.nodes.size()));
          for (java.util.Map.Entry<java.lang.Integer, PlanNode> _iter74 : struct.nodes.entrySet())
          {
            oprot.writeI32(_iter74.getKey());
            _iter74.getValue().write(oprot);
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.sourceNodes != null) {
        oprot.writeFieldBegin(SOURCE_NODES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.sourceNodes.size()));
          for (int _iter75 : struct.sourceNodes)
          {
            oprot.writeI32(_iter75);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.sinkNodes != null) {
        oprot.writeFieldBegin(SINK_NODES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.sinkNodes.size()));
          for (int _iter76 : struct.sinkNodes)
          {
            oprot.writeI32(_iter76);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.others != null) {
        oprot.writeFieldBegin(OTHERS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.others.size()));
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter77 : struct.others.entrySet())
          {
            oprot.writeString(_iter77.getKey());
            oprot.writeString(_iter77.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PlanTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PlanTupleScheme getScheme() {
      return new PlanTupleScheme();
    }
  }

  private static class PlanTupleScheme extends org.apache.thrift.scheme.TupleScheme<Plan> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Plan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetNodes()) {
        optionals.set(0);
      }
      if (struct.isSetSourceNodes()) {
        optionals.set(1);
      }
      if (struct.isSetSinkNodes()) {
        optionals.set(2);
      }
      if (struct.isSetOthers()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetNodes()) {
        {
          oprot.writeI32(struct.nodes.size());
          for (java.util.Map.Entry<java.lang.Integer, PlanNode> _iter78 : struct.nodes.entrySet())
          {
            oprot.writeI32(_iter78.getKey());
            _iter78.getValue().write(oprot);
          }
        }
      }
      if (struct.isSetSourceNodes()) {
        {
          oprot.writeI32(struct.sourceNodes.size());
          for (int _iter79 : struct.sourceNodes)
          {
            oprot.writeI32(_iter79);
          }
        }
      }
      if (struct.isSetSinkNodes()) {
        {
          oprot.writeI32(struct.sinkNodes.size());
          for (int _iter80 : struct.sinkNodes)
          {
            oprot.writeI32(_iter80);
          }
        }
      }
      if (struct.isSetOthers()) {
        {
          oprot.writeI32(struct.others.size());
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter81 : struct.others.entrySet())
          {
            oprot.writeString(_iter81.getKey());
            oprot.writeString(_iter81.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Plan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map82 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.nodes = new java.util.HashMap<java.lang.Integer,PlanNode>(2*_map82.size);
          int _key83;
          @org.apache.thrift.annotation.Nullable PlanNode _val84;
          for (int _i85 = 0; _i85 < _map82.size; ++_i85)
          {
            _key83 = iprot.readI32();
            _val84 = new PlanNode();
            _val84.read(iprot);
            struct.nodes.put(_key83, _val84);
          }
        }
        struct.setNodesIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list86 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.sourceNodes = new java.util.ArrayList<java.lang.Integer>(_list86.size);
          int _elem87;
          for (int _i88 = 0; _i88 < _list86.size; ++_i88)
          {
            _elem87 = iprot.readI32();
            struct.sourceNodes.add(_elem87);
          }
        }
        struct.setSourceNodesIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list89 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.sinkNodes = new java.util.ArrayList<java.lang.Integer>(_list89.size);
          int _elem90;
          for (int _i91 = 0; _i91 < _list89.size; ++_i91)
          {
            _elem90 = iprot.readI32();
            struct.sinkNodes.add(_elem90);
          }
        }
        struct.setSinkNodesIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TMap _map92 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.others = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map92.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _key93;
          @org.apache.thrift.annotation.Nullable java.lang.String _val94;
          for (int _i95 = 0; _i95 < _map92.size; ++_i95)
          {
            _key93 = iprot.readString();
            _val94 = iprot.readString();
            struct.others.put(_key93, _val94);
          }
        }
        struct.setOthersIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

