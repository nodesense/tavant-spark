package workshop

import java.io.File

import org.apache.spark.sql.{Row, SaveMode, SparkSession}


 /* RUNNING HIVE

 hive --service metastore


*/


object SparkHiveExample extends  App {
  case class Record(key: Int, value: String)
  val warehouseLocation = new File("spark-warehouse").getAbsolutePath

  println("PAth " + warehouseLocation)

  val spark = SparkSession
    .builder()
    .master("local[1]")
    .appName("Spark Hive Example")
    .config("spark.sql.warehouse.dir", "/home/krish/apache-hive-2.3.7")
    .config("hive.metastore.uris", "thrift://localhost:9083")
    .enableHiveSupport()
    .getOrCreate()


  import spark.implicits._
  import spark.sql

  sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING) USING hive")
  sql("INSERT INTO TABLE src values (1, 'ONE')")
  //sql("LOAD DATA LOCAL INPATH 'examples/src/main/resources/kv1.txt' INTO TABLE src")

  //spark.sql("use mydb")
  // Queries are expressed in HiveQL
  sql("SELECT * FROM src").show()

  sql("SELECT * FROM test").show()
}
