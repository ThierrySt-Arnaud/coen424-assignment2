/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package output.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class IntOutput extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5250436436673879876L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"IntOutput\",\"namespace\":\"output.avro\",\"fields\":[{\"name\":\"sortedValues\",\"type\":{\"type\":\"array\",\"items\":\"long\"}},{\"name\":\"scaledValues\",\"type\":{\"type\":\"array\",\"items\":\"float\"}},{\"name\":\"min\",\"type\":\"long\"},{\"name\":\"max\",\"type\":\"long\"},{\"name\":\"median\",\"type\":\"long\"},{\"name\":\"ninety\",\"type\":\"long\"},{\"name\":\"stdDev\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<IntOutput> ENCODER =
      new BinaryMessageEncoder<IntOutput>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<IntOutput> DECODER =
      new BinaryMessageDecoder<IntOutput>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<IntOutput> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<IntOutput> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<IntOutput> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<IntOutput>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this IntOutput to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a IntOutput from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a IntOutput instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static IntOutput fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.List<java.lang.Long> sortedValues;
  @Deprecated public java.util.List<java.lang.Float> scaledValues;
  @Deprecated public long min;
  @Deprecated public long max;
  @Deprecated public long median;
  @Deprecated public long ninety;
  @Deprecated public double stdDev;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public IntOutput() {}

  /**
   * All-args constructor.
   * @param sortedValues The new value for sortedValues
   * @param scaledValues The new value for scaledValues
   * @param min The new value for min
   * @param max The new value for max
   * @param median The new value for median
   * @param ninety The new value for ninety
   * @param stdDev The new value for stdDev
   */
  public IntOutput(java.util.List<java.lang.Long> sortedValues, java.util.List<java.lang.Float> scaledValues, java.lang.Long min, java.lang.Long max, java.lang.Long median, java.lang.Long ninety, java.lang.Double stdDev) {
    this.sortedValues = sortedValues;
    this.scaledValues = scaledValues;
    this.min = min;
    this.max = max;
    this.median = median;
    this.ninety = ninety;
    this.stdDev = stdDev;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return sortedValues;
    case 1: return scaledValues;
    case 2: return min;
    case 3: return max;
    case 4: return median;
    case 5: return ninety;
    case 6: return stdDev;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: sortedValues = (java.util.List<java.lang.Long>)value$; break;
    case 1: scaledValues = (java.util.List<java.lang.Float>)value$; break;
    case 2: min = (java.lang.Long)value$; break;
    case 3: max = (java.lang.Long)value$; break;
    case 4: median = (java.lang.Long)value$; break;
    case 5: ninety = (java.lang.Long)value$; break;
    case 6: stdDev = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'sortedValues' field.
   * @return The value of the 'sortedValues' field.
   */
  public java.util.List<java.lang.Long> getSortedValues() {
    return sortedValues;
  }


  /**
   * Sets the value of the 'sortedValues' field.
   * @param value the value to set.
   */
  public void setSortedValues(java.util.List<java.lang.Long> value) {
    this.sortedValues = value;
  }

  /**
   * Gets the value of the 'scaledValues' field.
   * @return The value of the 'scaledValues' field.
   */
  public java.util.List<java.lang.Float> getScaledValues() {
    return scaledValues;
  }


  /**
   * Sets the value of the 'scaledValues' field.
   * @param value the value to set.
   */
  public void setScaledValues(java.util.List<java.lang.Float> value) {
    this.scaledValues = value;
  }

  /**
   * Gets the value of the 'min' field.
   * @return The value of the 'min' field.
   */
  public long getMin() {
    return min;
  }


  /**
   * Sets the value of the 'min' field.
   * @param value the value to set.
   */
  public void setMin(long value) {
    this.min = value;
  }

  /**
   * Gets the value of the 'max' field.
   * @return The value of the 'max' field.
   */
  public long getMax() {
    return max;
  }


  /**
   * Sets the value of the 'max' field.
   * @param value the value to set.
   */
  public void setMax(long value) {
    this.max = value;
  }

  /**
   * Gets the value of the 'median' field.
   * @return The value of the 'median' field.
   */
  public long getMedian() {
    return median;
  }


  /**
   * Sets the value of the 'median' field.
   * @param value the value to set.
   */
  public void setMedian(long value) {
    this.median = value;
  }

  /**
   * Gets the value of the 'ninety' field.
   * @return The value of the 'ninety' field.
   */
  public long getNinety() {
    return ninety;
  }


  /**
   * Sets the value of the 'ninety' field.
   * @param value the value to set.
   */
  public void setNinety(long value) {
    this.ninety = value;
  }

  /**
   * Gets the value of the 'stdDev' field.
   * @return The value of the 'stdDev' field.
   */
  public double getStdDev() {
    return stdDev;
  }


  /**
   * Sets the value of the 'stdDev' field.
   * @param value the value to set.
   */
  public void setStdDev(double value) {
    this.stdDev = value;
  }

  /**
   * Creates a new IntOutput RecordBuilder.
   * @return A new IntOutput RecordBuilder
   */
  public static output.avro.IntOutput.Builder newBuilder() {
    return new output.avro.IntOutput.Builder();
  }

  /**
   * Creates a new IntOutput RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new IntOutput RecordBuilder
   */
  public static output.avro.IntOutput.Builder newBuilder(output.avro.IntOutput.Builder other) {
    if (other == null) {
      return new output.avro.IntOutput.Builder();
    } else {
      return new output.avro.IntOutput.Builder(other);
    }
  }

  /**
   * Creates a new IntOutput RecordBuilder by copying an existing IntOutput instance.
   * @param other The existing instance to copy.
   * @return A new IntOutput RecordBuilder
   */
  public static output.avro.IntOutput.Builder newBuilder(output.avro.IntOutput other) {
    if (other == null) {
      return new output.avro.IntOutput.Builder();
    } else {
      return new output.avro.IntOutput.Builder(other);
    }
  }

  /**
   * RecordBuilder for IntOutput instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<IntOutput>
    implements org.apache.avro.data.RecordBuilder<IntOutput> {

    private java.util.List<java.lang.Long> sortedValues;
    private java.util.List<java.lang.Float> scaledValues;
    private long min;
    private long max;
    private long median;
    private long ninety;
    private double stdDev;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(output.avro.IntOutput.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.sortedValues)) {
        this.sortedValues = data().deepCopy(fields()[0].schema(), other.sortedValues);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.scaledValues)) {
        this.scaledValues = data().deepCopy(fields()[1].schema(), other.scaledValues);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.min)) {
        this.min = data().deepCopy(fields()[2].schema(), other.min);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.max)) {
        this.max = data().deepCopy(fields()[3].schema(), other.max);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.median)) {
        this.median = data().deepCopy(fields()[4].schema(), other.median);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.ninety)) {
        this.ninety = data().deepCopy(fields()[5].schema(), other.ninety);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.stdDev)) {
        this.stdDev = data().deepCopy(fields()[6].schema(), other.stdDev);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing IntOutput instance
     * @param other The existing instance to copy.
     */
    private Builder(output.avro.IntOutput other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.sortedValues)) {
        this.sortedValues = data().deepCopy(fields()[0].schema(), other.sortedValues);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.scaledValues)) {
        this.scaledValues = data().deepCopy(fields()[1].schema(), other.scaledValues);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.min)) {
        this.min = data().deepCopy(fields()[2].schema(), other.min);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.max)) {
        this.max = data().deepCopy(fields()[3].schema(), other.max);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.median)) {
        this.median = data().deepCopy(fields()[4].schema(), other.median);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.ninety)) {
        this.ninety = data().deepCopy(fields()[5].schema(), other.ninety);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.stdDev)) {
        this.stdDev = data().deepCopy(fields()[6].schema(), other.stdDev);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'sortedValues' field.
      * @return The value.
      */
    public java.util.List<java.lang.Long> getSortedValues() {
      return sortedValues;
    }


    /**
      * Sets the value of the 'sortedValues' field.
      * @param value The value of 'sortedValues'.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder setSortedValues(java.util.List<java.lang.Long> value) {
      validate(fields()[0], value);
      this.sortedValues = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'sortedValues' field has been set.
      * @return True if the 'sortedValues' field has been set, false otherwise.
      */
    public boolean hasSortedValues() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'sortedValues' field.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder clearSortedValues() {
      sortedValues = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'scaledValues' field.
      * @return The value.
      */
    public java.util.List<java.lang.Float> getScaledValues() {
      return scaledValues;
    }


    /**
      * Sets the value of the 'scaledValues' field.
      * @param value The value of 'scaledValues'.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder setScaledValues(java.util.List<java.lang.Float> value) {
      validate(fields()[1], value);
      this.scaledValues = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'scaledValues' field has been set.
      * @return True if the 'scaledValues' field has been set, false otherwise.
      */
    public boolean hasScaledValues() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'scaledValues' field.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder clearScaledValues() {
      scaledValues = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'min' field.
      * @return The value.
      */
    public long getMin() {
      return min;
    }


    /**
      * Sets the value of the 'min' field.
      * @param value The value of 'min'.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder setMin(long value) {
      validate(fields()[2], value);
      this.min = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'min' field has been set.
      * @return True if the 'min' field has been set, false otherwise.
      */
    public boolean hasMin() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'min' field.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder clearMin() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'max' field.
      * @return The value.
      */
    public long getMax() {
      return max;
    }


    /**
      * Sets the value of the 'max' field.
      * @param value The value of 'max'.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder setMax(long value) {
      validate(fields()[3], value);
      this.max = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'max' field has been set.
      * @return True if the 'max' field has been set, false otherwise.
      */
    public boolean hasMax() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'max' field.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder clearMax() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'median' field.
      * @return The value.
      */
    public long getMedian() {
      return median;
    }


    /**
      * Sets the value of the 'median' field.
      * @param value The value of 'median'.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder setMedian(long value) {
      validate(fields()[4], value);
      this.median = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'median' field has been set.
      * @return True if the 'median' field has been set, false otherwise.
      */
    public boolean hasMedian() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'median' field.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder clearMedian() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'ninety' field.
      * @return The value.
      */
    public long getNinety() {
      return ninety;
    }


    /**
      * Sets the value of the 'ninety' field.
      * @param value The value of 'ninety'.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder setNinety(long value) {
      validate(fields()[5], value);
      this.ninety = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'ninety' field has been set.
      * @return True if the 'ninety' field has been set, false otherwise.
      */
    public boolean hasNinety() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'ninety' field.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder clearNinety() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'stdDev' field.
      * @return The value.
      */
    public double getStdDev() {
      return stdDev;
    }


    /**
      * Sets the value of the 'stdDev' field.
      * @param value The value of 'stdDev'.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder setStdDev(double value) {
      validate(fields()[6], value);
      this.stdDev = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'stdDev' field has been set.
      * @return True if the 'stdDev' field has been set, false otherwise.
      */
    public boolean hasStdDev() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'stdDev' field.
      * @return This builder.
      */
    public output.avro.IntOutput.Builder clearStdDev() {
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IntOutput build() {
      try {
        IntOutput record = new IntOutput();
        record.sortedValues = fieldSetFlags()[0] ? this.sortedValues : (java.util.List<java.lang.Long>) defaultValue(fields()[0]);
        record.scaledValues = fieldSetFlags()[1] ? this.scaledValues : (java.util.List<java.lang.Float>) defaultValue(fields()[1]);
        record.min = fieldSetFlags()[2] ? this.min : (java.lang.Long) defaultValue(fields()[2]);
        record.max = fieldSetFlags()[3] ? this.max : (java.lang.Long) defaultValue(fields()[3]);
        record.median = fieldSetFlags()[4] ? this.median : (java.lang.Long) defaultValue(fields()[4]);
        record.ninety = fieldSetFlags()[5] ? this.ninety : (java.lang.Long) defaultValue(fields()[5]);
        record.stdDev = fieldSetFlags()[6] ? this.stdDev : (java.lang.Double) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<IntOutput>
    WRITER$ = (org.apache.avro.io.DatumWriter<IntOutput>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<IntOutput>
    READER$ = (org.apache.avro.io.DatumReader<IntOutput>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    long size0 = this.sortedValues.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (java.lang.Long e0: this.sortedValues) {
      actualSize0++;
      out.startItem();
      out.writeLong(e0);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

    long size1 = this.scaledValues.size();
    out.writeArrayStart();
    out.setItemCount(size1);
    long actualSize1 = 0;
    for (java.lang.Float e1: this.scaledValues) {
      actualSize1++;
      out.startItem();
      out.writeFloat(e1);
    }
    out.writeArrayEnd();
    if (actualSize1 != size1)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size1 + ", but element count was " + actualSize1 + ".");

    out.writeLong(this.min);

    out.writeLong(this.max);

    out.writeLong(this.median);

    out.writeLong(this.ninety);

    out.writeDouble(this.stdDev);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      long size0 = in.readArrayStart();
      java.util.List<java.lang.Long> a0 = this.sortedValues;
      if (a0 == null) {
        a0 = new SpecificData.Array<java.lang.Long>((int)size0, SCHEMA$.getField("sortedValues").schema());
        this.sortedValues = a0;
      } else a0.clear();
      SpecificData.Array<java.lang.Long> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.Long>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          java.lang.Long e0 = (ga0 != null ? ga0.peek() : null);
          e0 = in.readLong();
          a0.add(e0);
        }
      }

      long size1 = in.readArrayStart();
      java.util.List<java.lang.Float> a1 = this.scaledValues;
      if (a1 == null) {
        a1 = new SpecificData.Array<java.lang.Float>((int)size1, SCHEMA$.getField("scaledValues").schema());
        this.scaledValues = a1;
      } else a1.clear();
      SpecificData.Array<java.lang.Float> ga1 = (a1 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.Float>)a1 : null);
      for ( ; 0 < size1; size1 = in.arrayNext()) {
        for ( ; size1 != 0; size1--) {
          java.lang.Float e1 = (ga1 != null ? ga1.peek() : null);
          e1 = in.readFloat();
          a1.add(e1);
        }
      }

      this.min = in.readLong();

      this.max = in.readLong();

      this.median = in.readLong();

      this.ninety = in.readLong();

      this.stdDev = in.readDouble();

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          long size0 = in.readArrayStart();
          java.util.List<java.lang.Long> a0 = this.sortedValues;
          if (a0 == null) {
            a0 = new SpecificData.Array<java.lang.Long>((int)size0, SCHEMA$.getField("sortedValues").schema());
            this.sortedValues = a0;
          } else a0.clear();
          SpecificData.Array<java.lang.Long> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.Long>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              java.lang.Long e0 = (ga0 != null ? ga0.peek() : null);
              e0 = in.readLong();
              a0.add(e0);
            }
          }
          break;

        case 1:
          long size1 = in.readArrayStart();
          java.util.List<java.lang.Float> a1 = this.scaledValues;
          if (a1 == null) {
            a1 = new SpecificData.Array<java.lang.Float>((int)size1, SCHEMA$.getField("scaledValues").schema());
            this.scaledValues = a1;
          } else a1.clear();
          SpecificData.Array<java.lang.Float> ga1 = (a1 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.Float>)a1 : null);
          for ( ; 0 < size1; size1 = in.arrayNext()) {
            for ( ; size1 != 0; size1--) {
              java.lang.Float e1 = (ga1 != null ? ga1.peek() : null);
              e1 = in.readFloat();
              a1.add(e1);
            }
          }
          break;

        case 2:
          this.min = in.readLong();
          break;

        case 3:
          this.max = in.readLong();
          break;

        case 4:
          this.median = in.readLong();
          break;

        case 5:
          this.ninety = in.readLong();
          break;

        case 6:
          this.stdDev = in.readDouble();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









