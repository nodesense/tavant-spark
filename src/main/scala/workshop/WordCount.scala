package workshop
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._  // _ means here, import all
import org.apache.spark.SparkConf

// Spark Driver program
object WordCount extends  App {
  // launch spark on local JVM, development
  // also launch spark web ui 4040, if 4040 already reserved, it opens 4041, 4042, ....
  // setMaster decides whether you run spark in local development or cluster
  val conf = new SparkConf()
                      .setMaster("local[1]") // development, not for production, use 2 CPU Cores
                      .setAppName("WordCountApp")

  val sc = new SparkContext(conf)
  //sc.setLogLevel("error")
  val textFile = sc.textFile("file:///Users/krish/input.txt")

  // (apple, 1)
  // (apple, 1)

  // key is apple
  // value is 1
  // acc? is cumulative total, result of acc + value
  // acc starts with 0
  // acc + value = 1, spark take this, assign to acc = 1
  // acc + value = 1 + 1 , acc = 2

  // flatMap, map are tasks
  // line => line.split(" ") is basically job
  val wordCounts = textFile.flatMap(line => line.split(" "))
                            .map (word => (word, 1)) // until here stage 0
                                // suffle data, group the items together in partition
                            .reduceByKey( (acc, value) => { // stage 1, after suffle
                              println(s"acc, $acc, value $value")
                              acc + value
                            })

  wordCounts.saveAsTextFile("file:///Users/krish/output-words-count5")

  sc.stop()
  println("Done successfully")
}
