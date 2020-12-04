package workshop

import java.io.File

import org.apache.spark.sql.{Row, SaveMode, SparkSession}

object SparkHiveHelloWorld extends  App {

    // spark shall use for meta data store by default
    // shall use default hive config, initialize meta store etc
    // property setting
    // if not set, it uses SPARK_HOME
    val warehouseLocation = new File("spark-warehouse").getAbsolutePath

    println("PAth " + warehouseLocation)

    val spark = SparkSession
      .builder()
      .master("local[1]")
      .appName("Spark Hive Example")
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .enableHiveSupport()
      .getOrCreate()


    import spark.implicits._
    import spark.sql

    sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING) USING hive")
    // While using HIVE on Spark, map-reduce engine is not used
    sql("INSERT INTO TABLE src values (1, 'ONE')")

    sql("SELECT * FROM brands").show()
}
