/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package ndbench.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Sample extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6780388850311072092L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Sample\",\"namespace\":\"ndbench.avro\",\"fields\":[{\"name\":\"cpu\",\"type\":\"int\"},{\"name\":\"netin\",\"type\":\"int\"},{\"name\":\"netout\",\"type\":\"int\"},{\"name\":\"mem\",\"type\":\"float\"},{\"name\":\"tgt\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Sample> ENCODER =
      new BinaryMessageEncoder<Sample>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Sample> DECODER =
      new BinaryMessageDecoder<Sample>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Sample> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Sample> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Sample> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Sample>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Sample to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Sample from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Sample instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Sample fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int cpu;
  @Deprecated public int netin;
  @Deprecated public int netout;
  @Deprecated public float mem;
  @Deprecated public float tgt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Sample() {}

  /**
   * All-args constructor.
   * @param cpu The new value for cpu
   * @param netin The new value for netin
   * @param netout The new value for netout
   * @param mem The new value for mem
   * @param tgt The new value for tgt
   */
  public Sample(java.lang.Integer cpu, java.lang.Integer netin, java.lang.Integer netout, java.lang.Float mem, java.lang.Float tgt) {
    this.cpu = cpu;
    this.netin = netin;
    this.netout = netout;
    this.mem = mem;
    this.tgt = tgt;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return cpu;
    case 1: return netin;
    case 2: return netout;
    case 3: return mem;
    case 4: return tgt;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: cpu = (java.lang.Integer)value$; break;
    case 1: netin = (java.lang.Integer)value$; break;
    case 2: netout = (java.lang.Integer)value$; break;
    case 3: mem = (java.lang.Float)value$; break;
    case 4: tgt = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'cpu' field.
   * @return The value of the 'cpu' field.
   */
  public int getCpu() {
    return cpu;
  }


  /**
   * Sets the value of the 'cpu' field.
   * @param value the value to set.
   */
  public void setCpu(int value) {
    this.cpu = value;
  }

  /**
   * Gets the value of the 'netin' field.
   * @return The value of the 'netin' field.
   */
  public int getNetin() {
    return netin;
  }


  /**
   * Sets the value of the 'netin' field.
   * @param value the value to set.
   */
  public void setNetin(int value) {
    this.netin = value;
  }

  /**
   * Gets the value of the 'netout' field.
   * @return The value of the 'netout' field.
   */
  public int getNetout() {
    return netout;
  }


  /**
   * Sets the value of the 'netout' field.
   * @param value the value to set.
   */
  public void setNetout(int value) {
    this.netout = value;
  }

  /**
   * Gets the value of the 'mem' field.
   * @return The value of the 'mem' field.
   */
  public float getMem() {
    return mem;
  }


  /**
   * Sets the value of the 'mem' field.
   * @param value the value to set.
   */
  public void setMem(float value) {
    this.mem = value;
  }

  /**
   * Gets the value of the 'tgt' field.
   * @return The value of the 'tgt' field.
   */
  public float getTgt() {
    return tgt;
  }


  /**
   * Sets the value of the 'tgt' field.
   * @param value the value to set.
   */
  public void setTgt(float value) {
    this.tgt = value;
  }

  /**
   * Creates a new Sample RecordBuilder.
   * @return A new Sample RecordBuilder
   */
  public static ndbench.avro.Sample.Builder newBuilder() {
    return new ndbench.avro.Sample.Builder();
  }

  /**
   * Creates a new Sample RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Sample RecordBuilder
   */
  public static ndbench.avro.Sample.Builder newBuilder(ndbench.avro.Sample.Builder other) {
    if (other == null) {
      return new ndbench.avro.Sample.Builder();
    } else {
      return new ndbench.avro.Sample.Builder(other);
    }
  }

  /**
   * Creates a new Sample RecordBuilder by copying an existing Sample instance.
   * @param other The existing instance to copy.
   * @return A new Sample RecordBuilder
   */
  public static ndbench.avro.Sample.Builder newBuilder(ndbench.avro.Sample other) {
    if (other == null) {
      return new ndbench.avro.Sample.Builder();
    } else {
      return new ndbench.avro.Sample.Builder(other);
    }
  }

  /**
   * RecordBuilder for Sample instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Sample>
    implements org.apache.avro.data.RecordBuilder<Sample> {

    private int cpu;
    private int netin;
    private int netout;
    private float mem;
    private float tgt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(ndbench.avro.Sample.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.cpu)) {
        this.cpu = data().deepCopy(fields()[0].schema(), other.cpu);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.netin)) {
        this.netin = data().deepCopy(fields()[1].schema(), other.netin);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.netout)) {
        this.netout = data().deepCopy(fields()[2].schema(), other.netout);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.mem)) {
        this.mem = data().deepCopy(fields()[3].schema(), other.mem);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.tgt)) {
        this.tgt = data().deepCopy(fields()[4].schema(), other.tgt);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing Sample instance
     * @param other The existing instance to copy.
     */
    private Builder(ndbench.avro.Sample other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.cpu)) {
        this.cpu = data().deepCopy(fields()[0].schema(), other.cpu);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.netin)) {
        this.netin = data().deepCopy(fields()[1].schema(), other.netin);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.netout)) {
        this.netout = data().deepCopy(fields()[2].schema(), other.netout);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.mem)) {
        this.mem = data().deepCopy(fields()[3].schema(), other.mem);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.tgt)) {
        this.tgt = data().deepCopy(fields()[4].schema(), other.tgt);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'cpu' field.
      * @return The value.
      */
    public int getCpu() {
      return cpu;
    }


    /**
      * Sets the value of the 'cpu' field.
      * @param value The value of 'cpu'.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder setCpu(int value) {
      validate(fields()[0], value);
      this.cpu = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'cpu' field has been set.
      * @return True if the 'cpu' field has been set, false otherwise.
      */
    public boolean hasCpu() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'cpu' field.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder clearCpu() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'netin' field.
      * @return The value.
      */
    public int getNetin() {
      return netin;
    }


    /**
      * Sets the value of the 'netin' field.
      * @param value The value of 'netin'.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder setNetin(int value) {
      validate(fields()[1], value);
      this.netin = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'netin' field has been set.
      * @return True if the 'netin' field has been set, false otherwise.
      */
    public boolean hasNetin() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'netin' field.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder clearNetin() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'netout' field.
      * @return The value.
      */
    public int getNetout() {
      return netout;
    }


    /**
      * Sets the value of the 'netout' field.
      * @param value The value of 'netout'.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder setNetout(int value) {
      validate(fields()[2], value);
      this.netout = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'netout' field has been set.
      * @return True if the 'netout' field has been set, false otherwise.
      */
    public boolean hasNetout() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'netout' field.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder clearNetout() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'mem' field.
      * @return The value.
      */
    public float getMem() {
      return mem;
    }


    /**
      * Sets the value of the 'mem' field.
      * @param value The value of 'mem'.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder setMem(float value) {
      validate(fields()[3], value);
      this.mem = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'mem' field has been set.
      * @return True if the 'mem' field has been set, false otherwise.
      */
    public boolean hasMem() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'mem' field.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder clearMem() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'tgt' field.
      * @return The value.
      */
    public float getTgt() {
      return tgt;
    }


    /**
      * Sets the value of the 'tgt' field.
      * @param value The value of 'tgt'.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder setTgt(float value) {
      validate(fields()[4], value);
      this.tgt = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'tgt' field has been set.
      * @return True if the 'tgt' field has been set, false otherwise.
      */
    public boolean hasTgt() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'tgt' field.
      * @return This builder.
      */
    public ndbench.avro.Sample.Builder clearTgt() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Sample build() {
      try {
        Sample record = new Sample();
        record.cpu = fieldSetFlags()[0] ? this.cpu : (java.lang.Integer) defaultValue(fields()[0]);
        record.netin = fieldSetFlags()[1] ? this.netin : (java.lang.Integer) defaultValue(fields()[1]);
        record.netout = fieldSetFlags()[2] ? this.netout : (java.lang.Integer) defaultValue(fields()[2]);
        record.mem = fieldSetFlags()[3] ? this.mem : (java.lang.Float) defaultValue(fields()[3]);
        record.tgt = fieldSetFlags()[4] ? this.tgt : (java.lang.Float) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Sample>
    WRITER$ = (org.apache.avro.io.DatumWriter<Sample>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Sample>
    READER$ = (org.apache.avro.io.DatumReader<Sample>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.cpu);

    out.writeInt(this.netin);

    out.writeInt(this.netout);

    out.writeFloat(this.mem);

    out.writeFloat(this.tgt);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.cpu = in.readInt();

      this.netin = in.readInt();

      this.netout = in.readInt();

      this.mem = in.readFloat();

      this.tgt = in.readFloat();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.cpu = in.readInt();
          break;

        case 1:
          this.netin = in.readInt();
          break;

        case 2:
          this.netout = in.readInt();
          break;

        case 3:
          this.mem = in.readFloat();
          break;

        case 4:
          this.tgt = in.readFloat();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










