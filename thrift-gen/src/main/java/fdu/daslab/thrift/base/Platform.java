/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package fdu.daslab.thrift.base;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2021-10-11")
public class Platform implements org.apache.thrift.TBase<Platform, Platform._Fields>, java.io.Serializable, Cloneable, Comparable<Platform> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Platform");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DEFAULT_IMAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("defaultImage", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField USE_OPERATOR_FIELD_DESC = new org.apache.thrift.protocol.TField("useOperator", org.apache.thrift.protocol.TType.BOOL, (short)3);
  private static final org.apache.thrift.protocol.TField EXEC_COMMAND_FIELD_DESC = new org.apache.thrift.protocol.TField("execCommand", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField LANGUAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("language", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("params", org.apache.thrift.protocol.TType.MAP, (short)16);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PlatformStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PlatformTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String name; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String defaultImage; // required
  public boolean useOperator; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String execCommand; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String language; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> params; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    DEFAULT_IMAGE((short)2, "defaultImage"),
    USE_OPERATOR((short)3, "useOperator"),
    EXEC_COMMAND((short)4, "execCommand"),
    LANGUAGE((short)5, "language"),
    PARAMS((short)16, "params");

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
        case 1: // NAME
          return NAME;
        case 2: // DEFAULT_IMAGE
          return DEFAULT_IMAGE;
        case 3: // USE_OPERATOR
          return USE_OPERATOR;
        case 4: // EXEC_COMMAND
          return EXEC_COMMAND;
        case 5: // LANGUAGE
          return LANGUAGE;
        case 16: // PARAMS
          return PARAMS;
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
  private static final int __USEOPERATOR_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEFAULT_IMAGE, new org.apache.thrift.meta_data.FieldMetaData("defaultImage", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USE_OPERATOR, new org.apache.thrift.meta_data.FieldMetaData("useOperator", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.EXEC_COMMAND, new org.apache.thrift.meta_data.FieldMetaData("execCommand", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LANGUAGE, new org.apache.thrift.meta_data.FieldMetaData("language", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARAMS, new org.apache.thrift.meta_data.FieldMetaData("params", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Platform.class, metaDataMap);
  }

  public Platform() {
    this.params = new java.util.HashMap<java.lang.String,java.lang.String>();

  }

  public Platform(
    java.lang.String name,
    java.lang.String defaultImage,
    boolean useOperator,
    java.lang.String execCommand,
    java.lang.String language,
    java.util.Map<java.lang.String,java.lang.String> params)
  {
    this();
    this.name = name;
    this.defaultImage = defaultImage;
    this.useOperator = useOperator;
    setUseOperatorIsSet(true);
    this.execCommand = execCommand;
    this.language = language;
    this.params = params;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Platform(Platform other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetDefaultImage()) {
      this.defaultImage = other.defaultImage;
    }
    this.useOperator = other.useOperator;
    if (other.isSetExecCommand()) {
      this.execCommand = other.execCommand;
    }
    if (other.isSetLanguage()) {
      this.language = other.language;
    }
    if (other.isSetParams()) {
      java.util.Map<java.lang.String,java.lang.String> __this__params = new java.util.HashMap<java.lang.String,java.lang.String>(other.params);
      this.params = __this__params;
    }
  }

  public Platform deepCopy() {
    return new Platform(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.defaultImage = null;
    setUseOperatorIsSet(false);
    this.useOperator = false;
    this.execCommand = null;
    this.language = null;
    this.params = new java.util.HashMap<java.lang.String,java.lang.String>();

  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getName() {
    return this.name;
  }

  public Platform setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getDefaultImage() {
    return this.defaultImage;
  }

  public Platform setDefaultImage(@org.apache.thrift.annotation.Nullable java.lang.String defaultImage) {
    this.defaultImage = defaultImage;
    return this;
  }

  public void unsetDefaultImage() {
    this.defaultImage = null;
  }

  /** Returns true if field defaultImage is set (has been assigned a value) and false otherwise */
  public boolean isSetDefaultImage() {
    return this.defaultImage != null;
  }

  public void setDefaultImageIsSet(boolean value) {
    if (!value) {
      this.defaultImage = null;
    }
  }

  public boolean isUseOperator() {
    return this.useOperator;
  }

  public Platform setUseOperator(boolean useOperator) {
    this.useOperator = useOperator;
    setUseOperatorIsSet(true);
    return this;
  }

  public void unsetUseOperator() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __USEOPERATOR_ISSET_ID);
  }

  /** Returns true if field useOperator is set (has been assigned a value) and false otherwise */
  public boolean isSetUseOperator() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __USEOPERATOR_ISSET_ID);
  }

  public void setUseOperatorIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __USEOPERATOR_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getExecCommand() {
    return this.execCommand;
  }

  public Platform setExecCommand(@org.apache.thrift.annotation.Nullable java.lang.String execCommand) {
    this.execCommand = execCommand;
    return this;
  }

  public void unsetExecCommand() {
    this.execCommand = null;
  }

  /** Returns true if field execCommand is set (has been assigned a value) and false otherwise */
  public boolean isSetExecCommand() {
    return this.execCommand != null;
  }

  public void setExecCommandIsSet(boolean value) {
    if (!value) {
      this.execCommand = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getLanguage() {
    return this.language;
  }

  public Platform setLanguage(@org.apache.thrift.annotation.Nullable java.lang.String language) {
    this.language = language;
    return this;
  }

  public void unsetLanguage() {
    this.language = null;
  }

  /** Returns true if field language is set (has been assigned a value) and false otherwise */
  public boolean isSetLanguage() {
    return this.language != null;
  }

  public void setLanguageIsSet(boolean value) {
    if (!value) {
      this.language = null;
    }
  }

  public int getParamsSize() {
    return (this.params == null) ? 0 : this.params.size();
  }

  public void putToParams(java.lang.String key, java.lang.String val) {
    if (this.params == null) {
      this.params = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.params.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getParams() {
    return this.params;
  }

  public Platform setParams(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> params) {
    this.params = params;
    return this;
  }

  public void unsetParams() {
    this.params = null;
  }

  /** Returns true if field params is set (has been assigned a value) and false otherwise */
  public boolean isSetParams() {
    return this.params != null;
  }

  public void setParamsIsSet(boolean value) {
    if (!value) {
      this.params = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case DEFAULT_IMAGE:
      if (value == null) {
        unsetDefaultImage();
      } else {
        setDefaultImage((java.lang.String)value);
      }
      break;

    case USE_OPERATOR:
      if (value == null) {
        unsetUseOperator();
      } else {
        setUseOperator((java.lang.Boolean)value);
      }
      break;

    case EXEC_COMMAND:
      if (value == null) {
        unsetExecCommand();
      } else {
        setExecCommand((java.lang.String)value);
      }
      break;

    case LANGUAGE:
      if (value == null) {
        unsetLanguage();
      } else {
        setLanguage((java.lang.String)value);
      }
      break;

    case PARAMS:
      if (value == null) {
        unsetParams();
      } else {
        setParams((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case DEFAULT_IMAGE:
      return getDefaultImage();

    case USE_OPERATOR:
      return isUseOperator();

    case EXEC_COMMAND:
      return getExecCommand();

    case LANGUAGE:
      return getLanguage();

    case PARAMS:
      return getParams();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case DEFAULT_IMAGE:
      return isSetDefaultImage();
    case USE_OPERATOR:
      return isSetUseOperator();
    case EXEC_COMMAND:
      return isSetExecCommand();
    case LANGUAGE:
      return isSetLanguage();
    case PARAMS:
      return isSetParams();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Platform)
      return this.equals((Platform)that);
    return false;
  }

  public boolean equals(Platform that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_defaultImage = true && this.isSetDefaultImage();
    boolean that_present_defaultImage = true && that.isSetDefaultImage();
    if (this_present_defaultImage || that_present_defaultImage) {
      if (!(this_present_defaultImage && that_present_defaultImage))
        return false;
      if (!this.defaultImage.equals(that.defaultImage))
        return false;
    }

    boolean this_present_useOperator = true;
    boolean that_present_useOperator = true;
    if (this_present_useOperator || that_present_useOperator) {
      if (!(this_present_useOperator && that_present_useOperator))
        return false;
      if (this.useOperator != that.useOperator)
        return false;
    }

    boolean this_present_execCommand = true && this.isSetExecCommand();
    boolean that_present_execCommand = true && that.isSetExecCommand();
    if (this_present_execCommand || that_present_execCommand) {
      if (!(this_present_execCommand && that_present_execCommand))
        return false;
      if (!this.execCommand.equals(that.execCommand))
        return false;
    }

    boolean this_present_language = true && this.isSetLanguage();
    boolean that_present_language = true && that.isSetLanguage();
    if (this_present_language || that_present_language) {
      if (!(this_present_language && that_present_language))
        return false;
      if (!this.language.equals(that.language))
        return false;
    }

    boolean this_present_params = true && this.isSetParams();
    boolean that_present_params = true && that.isSetParams();
    if (this_present_params || that_present_params) {
      if (!(this_present_params && that_present_params))
        return false;
      if (!this.params.equals(that.params))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetDefaultImage()) ? 131071 : 524287);
    if (isSetDefaultImage())
      hashCode = hashCode * 8191 + defaultImage.hashCode();

    hashCode = hashCode * 8191 + ((useOperator) ? 131071 : 524287);

    hashCode = hashCode * 8191 + ((isSetExecCommand()) ? 131071 : 524287);
    if (isSetExecCommand())
      hashCode = hashCode * 8191 + execCommand.hashCode();

    hashCode = hashCode * 8191 + ((isSetLanguage()) ? 131071 : 524287);
    if (isSetLanguage())
      hashCode = hashCode * 8191 + language.hashCode();

    hashCode = hashCode * 8191 + ((isSetParams()) ? 131071 : 524287);
    if (isSetParams())
      hashCode = hashCode * 8191 + params.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Platform other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDefaultImage()).compareTo(other.isSetDefaultImage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDefaultImage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.defaultImage, other.defaultImage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUseOperator()).compareTo(other.isSetUseOperator());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUseOperator()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.useOperator, other.useOperator);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetExecCommand()).compareTo(other.isSetExecCommand());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExecCommand()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.execCommand, other.execCommand);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetLanguage()).compareTo(other.isSetLanguage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLanguage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.language, other.language);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetParams()).compareTo(other.isSetParams());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParams()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.params, other.params);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Platform(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("defaultImage:");
    if (this.defaultImage == null) {
      sb.append("null");
    } else {
      sb.append(this.defaultImage);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("useOperator:");
    sb.append(this.useOperator);
    first = false;
    if (!first) sb.append(", ");
    sb.append("execCommand:");
    if (this.execCommand == null) {
      sb.append("null");
    } else {
      sb.append(this.execCommand);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("language:");
    if (this.language == null) {
      sb.append("null");
    } else {
      sb.append(this.language);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("params:");
    if (this.params == null) {
      sb.append("null");
    } else {
      sb.append(this.params);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PlatformStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PlatformStandardScheme getScheme() {
      return new PlatformStandardScheme();
    }
  }

  private static class PlatformStandardScheme extends org.apache.thrift.scheme.StandardScheme<Platform> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Platform struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DEFAULT_IMAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.defaultImage = iprot.readString();
              struct.setDefaultImageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USE_OPERATOR
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.useOperator = iprot.readBool();
              struct.setUseOperatorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXEC_COMMAND
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.execCommand = iprot.readString();
              struct.setExecCommandIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LANGUAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.language = iprot.readString();
              struct.setLanguageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 16: // PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.params = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map0.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key1;
                @org.apache.thrift.annotation.Nullable java.lang.String _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = iprot.readString();
                  _val2 = iprot.readString();
                  struct.params.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setParamsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Platform struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.defaultImage != null) {
        oprot.writeFieldBegin(DEFAULT_IMAGE_FIELD_DESC);
        oprot.writeString(struct.defaultImage);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(USE_OPERATOR_FIELD_DESC);
      oprot.writeBool(struct.useOperator);
      oprot.writeFieldEnd();
      if (struct.execCommand != null) {
        oprot.writeFieldBegin(EXEC_COMMAND_FIELD_DESC);
        oprot.writeString(struct.execCommand);
        oprot.writeFieldEnd();
      }
      if (struct.language != null) {
        oprot.writeFieldBegin(LANGUAGE_FIELD_DESC);
        oprot.writeString(struct.language);
        oprot.writeFieldEnd();
      }
      if (struct.params != null) {
        oprot.writeFieldBegin(PARAMS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.params.size()));
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter4 : struct.params.entrySet())
          {
            oprot.writeString(_iter4.getKey());
            oprot.writeString(_iter4.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PlatformTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PlatformTupleScheme getScheme() {
      return new PlatformTupleScheme();
    }
  }

  private static class PlatformTupleScheme extends org.apache.thrift.scheme.TupleScheme<Platform> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Platform struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetDefaultImage()) {
        optionals.set(1);
      }
      if (struct.isSetUseOperator()) {
        optionals.set(2);
      }
      if (struct.isSetExecCommand()) {
        optionals.set(3);
      }
      if (struct.isSetLanguage()) {
        optionals.set(4);
      }
      if (struct.isSetParams()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetDefaultImage()) {
        oprot.writeString(struct.defaultImage);
      }
      if (struct.isSetUseOperator()) {
        oprot.writeBool(struct.useOperator);
      }
      if (struct.isSetExecCommand()) {
        oprot.writeString(struct.execCommand);
      }
      if (struct.isSetLanguage()) {
        oprot.writeString(struct.language);
      }
      if (struct.isSetParams()) {
        {
          oprot.writeI32(struct.params.size());
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter5 : struct.params.entrySet())
          {
            oprot.writeString(_iter5.getKey());
            oprot.writeString(_iter5.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Platform struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.defaultImage = iprot.readString();
        struct.setDefaultImageIsSet(true);
      }
      if (incoming.get(2)) {
        struct.useOperator = iprot.readBool();
        struct.setUseOperatorIsSet(true);
      }
      if (incoming.get(3)) {
        struct.execCommand = iprot.readString();
        struct.setExecCommandIsSet(true);
      }
      if (incoming.get(4)) {
        struct.language = iprot.readString();
        struct.setLanguageIsSet(true);
      }
      if (incoming.get(5)) {
        {
          org.apache.thrift.protocol.TMap _map6 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.params = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map6.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _key7;
          @org.apache.thrift.annotation.Nullable java.lang.String _val8;
          for (int _i9 = 0; _i9 < _map6.size; ++_i9)
          {
            _key7 = iprot.readString();
            _val8 = iprot.readString();
            struct.params.put(_key7, _val8);
          }
        }
        struct.setParamsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

