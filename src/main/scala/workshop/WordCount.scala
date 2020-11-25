package workshop
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._  // _ means here, import all
import org.apache.spark.SparkConf

object WordCount extends  App {
  // launch spark on local JVM, development
  // also launch spark web ui 4040, if 4040 already reserved, it opens 4041, 4042, ....
  // setMaster decides whether you run spark in local development or cluster
  val conf = new SparkConf()
                      .setMaster("local[2]") // development, not for production, use 2 CPU Cores
                      .setAppName("WordCountApp")

  val sc = new SparkContext(conf)
  val textFile = sc.textFile("file:///Users/krish/input.txt")

  val wordCounts = textFile.flatMap(line => line.split(" "))
                            .map (word => (word, 1))
                            .reduceByKey( (acc, value) => acc + value)

  wordCounts.saveAsTextFile("file:///Users/krish/output-words-count")

  sc.stop()
  println("Done successfully")
}
