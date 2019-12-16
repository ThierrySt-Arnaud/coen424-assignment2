package ca.concordia.coen424.id27649460;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.*;

import org.apache.avro.mapred.AvroKey;
import org.apache.avro.mapreduce.AvroJob;
import org.apache.avro.mapreduce.AvroKeyInputFormat;
import org.apache.avro.mapreduce.AvroKeyOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Counters;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.CounterGroup;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import ndbench.avro.Sample;
import output.avro.FloatOutput;
import output.avro.IntOutput;


public class MapReduceSort{
    static final String filesystem = "hdfs://localhost:9000";

    public static class IntKey implements WritableComparable<IntKey>{
        private String field;
        private long val;
        private long sum;
        private int count;

        IntKey(){
            this.field = null;
            this.val = 0l;
            this.sum = 0l;
            this.count = 0;
        }

        IntKey(String field, long val){
            this.field = field;
            this.val = val;
            this.sum = 0l;
            this.count = 0;
        }
        
        @Override
        public void write(DataOutput out) throws IOException {
            out.writeUTF(this.field);
            out.writeLong(this.val);
            out.writeLong(this.sum);
            out.writeInt(this.count);
        }

        @Override
        public void readFields(DataInput in) throws IOException {
            field = in.readUTF();
            val = in.readLong();
            sum = in.readLong();
            count = in.readInt();
        }

        public int compareGroup(IntKey o){
            return this.field.compareTo(o.field);
        }

        @Override
        public int compareTo(IntKey o) {
            long thisValue = this.val;
            long thatValue = o.val;
            return (thisValue < thatValue ? -1 : (thisValue == thatValue ? 0 : 1));
        }

        @Override
        public int hashCode() {
            return field.hashCode();
        }

        @Override
        public boolean equals(Object o){
            final IntKey other = (IntKey) o;
            return this.field.equals(other.field);
        }

        @Override
        public String toString() {
            return "Field: " + this.field + ", Value: " + this.val;
        }
    }

    public static class IntKeyGroupComparator extends WritableComparator {
        public IntKeyGroupComparator() {
            super(IntKey.class, true);
        }

        @Override
        public int compare(WritableComparable a, WritableComparable b) {
            IntKey w1 = (IntKey) a;
            IntKey w2 = (IntKey) b;
            return w1.compareGroup(w2);
        }
    }


    public static class IntSortMapper extends Mapper<AvroKey<Sample>, NullWritable, IntKey, LongWritable> {
        private Logger logger = Logger.getLogger(IntSortMapper.class);

        @Override
        public void map(AvroKey<Sample> key, NullWritable value, Context context)
                throws IOException, InterruptedException {
            //logger.info("Entered IntSortMapper");
            Configuration conf = context.getConfiguration();
            String field = conf.get("field");
            Long val = 0l;
            switch(field){
                case "cpu":
                    val = (long) key.datum().getCpu();
                    break;
                case "netin":
                    val = (long) key.datum().getNetin();
                    break;
                case "netout":
                    val = (long) key.datum().getNetout();
                    break;
            }
            
            
            context.write(new IntKey(field, val), new LongWritable(val));
        }
    }

    public static class IntReducer
            extends Reducer<IntKey, LongWritable, AvroKey<IntOutput>, NullWritable> {
        private Logger logger = Logger.getLogger(IntReducer.class);

        @Override
        public void reduce(IntKey key, Iterable<LongWritable> values, Context context)
                throws IOException, InterruptedException {
            logger.info("Entered IntReducer");
            logger.info("Received IntKey " + key.toString());
            List<Long> valueList = new ArrayList<Long>();
            long sum = 0l;
            for (LongWritable d : values) {
                valueList.add(d.get());
                sum += d.get();
            }
            int count = valueList.size();
            Double average = (double) sum/(double) count;
            logger.info("Found " + count + " values");

            Long min = valueList.get(0);
            Long max = valueList.get(count-1);
            IntOutput output = new IntOutput();
            output.setMin(min);
            output.setMax(max);
            if (count % 2 == 0){
                Long median = valueList.get(count/2) + valueList.get(count / 2 - 1);
                output.setMedian(median/2);
            }   else{
                output.setMedian(valueList.get(count/2));
            }
            output.setNinety(valueList.get(count-count/10));
            
            Long diff = max - min;
            List<Float> scaledValues = new ArrayList<Float>();
            Double devsum = 0.0;
            for (Long v : valueList){   
                devsum += Math.pow((v - average),2);
                scaledValues.add((float)(v-min)/diff);
            }

            output.setScaledValues(scaledValues);
            output.setStdDev(Math.sqrt(devsum/count));


            context.write(new AvroKey<IntOutput>(output), null);
        }
    }

    public static class FloatKey implements WritableComparable<FloatKey>{
        private String field;
        private Double val;

        FloatKey(){

        }

        FloatKey(String field, Double val){
            this.field = field;
            this.val = val;
        }

        @Override
        public void write(DataOutput out) throws IOException {
            out.writeUTF(this.field);
            out.writeDouble(this.val);
        }

        @Override
        public void readFields(DataInput in) throws IOException {
            field = in.readUTF();
            val = in.readDouble();
        }

        public int compareGroup(FloatKey o) {
            return this.field.compareTo(o.field);
        }

        @Override
        public int compareTo(FloatKey o) {
            Double thisValue = this.val;
            Double thatValue = o.val;
            return (thisValue < thatValue ? -1 : (thisValue == thatValue ? 0 : 1));
        }

        @Override
        public int hashCode() {
            return field.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            final FloatKey other = (FloatKey) o;
            return this.field.equals(other.field);
        }

        @Override
        public String toString(){
            return "Field: " + this.field + ", Value: " + this.val;
        }
    }

    public static class FloatKeyGroupComparator extends WritableComparator {
        public FloatKeyGroupComparator() {
            super(FloatKey.class, true);
        }

        @Override
        public int compare(WritableComparable a, WritableComparable b) {
            FloatKey w1 = (FloatKey) a;
            FloatKey w2 = (FloatKey) b;
            return w1.compareGroup(w2);
        }
    }

    public static class FloatSortMapper extends Mapper<AvroKey<Sample>, NullWritable, FloatKey, DoubleWritable> {
        private Logger logger = Logger.getLogger(FloatSortMapper.class);

        @Override
        public void map(AvroKey<Sample> key, NullWritable value, Context context)
                throws IOException, InterruptedException {
            // logger.info("Entered FloatSortMapper");
            Configuration conf = context.getConfiguration();
            String field = conf.get("field");
            Double val = (double) key.datum().getMem();

            context.write(new FloatKey(field, val), new DoubleWritable(val));
        }
    }

    public static class FloatReducer
            extends Reducer<FloatKey, DoubleWritable, AvroKey<FloatOutput>, NullWritable> {
        private Logger logger = Logger.getLogger(FloatReducer.class);

        @Override
        public void reduce(FloatKey key, Iterable<DoubleWritable> values, Context context)
                throws IOException, InterruptedException {
            logger.info("Entered FloatReducer");
            logger.info("Received FloatKey " + key.toString());
            List<Double> valueList = new ArrayList<Double>();
            Double sum = 0.0;
            for (DoubleWritable d : values) {
                valueList.add(d.get());
                sum += d.get();
            }
            int count = valueList.size();
            Double average = sum / count;
            logger.info("Found " + count + " values");

            Double min = valueList.get(0);
            Double max = valueList.get(count - 1);

            FloatOutput output = new FloatOutput();
            output.setMin(min);
            output.setMax(max);
            if (count % 2 == 0) {
                Double median = valueList.get(count / 2) + valueList.get(count / 2 - 1);
                output.setMedian(median / 2);
            } else {
                output.setMedian(valueList.get(count / 2));
            }
            output.setNinety(valueList.get(count - count / 10));

            Double diff = max - min;
            List<Double> scaledValues = new ArrayList<Double>();
            Double devsum = 0.0;
            for (Double v : valueList) {
                devsum += Math.pow((v - average), 2);
                scaledValues.add((v - min) / diff);
            }

            output.setScaledValues(scaledValues);
            output.setStdDev(Math.sqrt(devsum / count));
            context.write(new AvroKey<FloatOutput>(output), null);
        }
    }

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        Configuration conf = new Configuration();
        GenericOptionsParser optionParser = new GenericOptionsParser(conf, args);
        String[] remArgs = optionParser.getRemainingArgs();
        if (remArgs.length != 2) {
            System.err.println("Usage: MapReduceSort <file> <metric>");
            System.exit(-1);
        }

        String field = remArgs[1].toLowerCase();
        conf.set("field", field);

        Job job = Job.getInstance(conf);
        job.setJarByClass(MapReduceSort.class);
        job.setJobName("Sorter");
        job.setInputFormatClass(AvroKeyInputFormat.class);
        AvroJob.setInputKeySchema(job, Sample.getClassSchema());
        job.setOutputFormatClass(AvroKeyOutputFormat.class);

        if (field.equals("mem")) {
            System.out.println("Using Floats");
            job.setMapperClass(FloatSortMapper.class);
            job.setMapOutputKeyClass(FloatKey.class);
            job.setMapOutputValueClass(DoubleWritable.class);
            job.setGroupingComparatorClass(FloatKeyGroupComparator.class);
            job.setReducerClass(FloatReducer.class);
            AvroJob.setOutputKeySchema(job, FloatOutput.getClassSchema());
        } else if (field.equals("cpu") || field.equals("netin") || field.equals("netout")) {
            System.out.println("Using Integers");
            job.setMapperClass(IntSortMapper.class);
            job.setMapOutputKeyClass(IntKey.class);
            job.setMapOutputValueClass(LongWritable.class);
            job.setGroupingComparatorClass(IntKeyGroupComparator.class);
            job.setReducerClass(IntReducer.class);
            AvroJob.setOutputKeySchema(job, IntOutput.getClassSchema());
        } else {
            System.err.println("Invalid metric. Use [cpu|netin|netout|mem]");
            System.exit(-1);
        }

        FileInputFormat.setInputPaths(job, new Path(filesystem + "/NDBench/" + remArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(filesystem + "/Output"));
        int result = job.waitForCompletion(true) ? 0 : 1;
        System.exit(result);
    }
}
