import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.OutputCollector;
import java.util.Iterator;
public class LineCount {
public static final String STR_HACKATHON="hackathon";
public static final String STR_DEC="dec";
public static final String STR_CHICAGO="chicago";
public static final String STR_JAVA="java"; 
/*public static void main(String[] args) throws IOException {
 if (args.length != 2) {
 System.err.println("Usage: MaxTemperature <input path> <output path>");
 System.exit(-1);
 }

 JobConf conf = new JobConf(MaxTemperature.class);
 conf.setNumReduceTasks(1);
 conf.setJobName("Max temperature");
 FileInputFormat.addInputPath(conf, new Path(args[0]));
 FileOutputFormat.setOutputPath(conf, new Path(args[1]));

 conf.setMapperClass(MaxTemperatureMapper.class);
 conf.setReducerClass(MaxTemperatureReducer.class);
 conf.setOutputKeyClass(Text.class);
 conf.setOutputValueClass(IntWritable.class);
 JobClient.runJob(conf);
 }
import org.apache.hadoop.mapred.Reporter;
public class MaxTemperatureMapper extends MapReduceBase
 implements Mapper<LongWritable, Text, Text, IntWritable> {
 private static final int MISSING = 9999;

 public void map(LongWritable key, Text value,
 OutputCollector<Text, IntWritable> output, Reporter reporter)
 throws IOException {
}import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
public class MaxTemperatureReducer extends MapReduceBase
 implements Reducer<Text, IntWritable, Text, IntWritable> {
 public void reduce(Text key, Iterator<IntWritable> values,
 OutputCollector<Text, IntWritable> output, Reporter reporter)
 throws IOException {*/
public static void main(String [] args) throws Exception
{
JobConf conf = new JobConf(LineCount.class);
conf.setNumReduceTasks(1);
conf.setJobName("LineCount");
FileInputFormat.addInputPath(conf, new Path(args[0]));
FileOutputFormat.setOutputPath(conf, new Path(args[1]));
conf.setJarByClass(LineCount.class);
conf.setMapperClass(MapForLineCount.class);
conf.setReducerClass(ReduceForLineCount.class);
conf.setOutputKeyClass(Text.class);
conf.setOutputValueClass(IntWritable.class);
JobClient.runJob(conf);
}
public static class MapForLineCount extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException
{
String line = value.toString();
output.collect(new Text(STR_HACKATHON), new IntWritable(0));
output.collect(new Text(STR_JAVA), new IntWritable(0));
output.collect(new Text(STR_CHICAGO), new IntWritable(0));
output.collect(new Text(STR_DEC), new IntWritable(0));

if(line.toLowerCase().contains(STR_HACKATHON))
{
      Text outputKey = new Text(STR_HACKATHON);
  IntWritable outputValue = new IntWritable(1);
  output.collect(outputKey, outputValue);
}
if(line.toLowerCase().contains(STR_DEC))
{
      Text outputKey = new Text(STR_DEC);
  IntWritable outputValue = new IntWritable(1);
  output.collect(outputKey, outputValue);
}
if(line.toLowerCase().contains(STR_JAVA))
{
      Text outputKey = new Text(STR_JAVA);
  IntWritable outputValue = new IntWritable(1);
  output.collect(outputKey, outputValue);
}
if(line.toLowerCase().contains(STR_CHICAGO))
{
      Text outputKey = new Text(STR_CHICAGO);
  IntWritable outputValue = new IntWritable(1);
  output.collect(outputKey, outputValue);
}


}
}

public static class ReduceForLineCount extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>
{
public void reduce(Text word, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException{
int sum = 0;
while(values.hasNext()){  
   sum += values.next().get();
}
   output.collect(word, new IntWritable(sum));
}
}
}
