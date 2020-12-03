package workshop

import org.apache.spark.sql.SparkSession

object SparkHadoopTextFile extends  App {
  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("FromHadoop")
    .getOrCreate()

  import spark.implicits._

  // replace localhost with ip address or domain name
  // val rddHadoopFile = spark.sparkContext.textFile("hdfs://localhost/test/order1.csv")
  val rddHadoopFile = spark.sparkContext.textFile("hdfs://k1.training.sh:9000/test/order1.csv")
  rddHadoopFile.foreach(println)
}
