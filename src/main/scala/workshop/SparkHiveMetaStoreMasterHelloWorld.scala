package workshop

import java.io.File

import org.apache.spark.sql.SparkSession


// class path, FQN - Fully Qualified Name
// packge path + class name

// package best practices - com.tavant.busservice.SparkHiveMetaStoreMasterHelloWorld
// FQN workshop.SparkHiveMetaStoreMasterHelloWorld

// jar generated in the target/scala2.11 folder

// master running on spark://sense:7077

// SparkHiveMetaStoreMasterHelloWorld is a driver program placed inside the jar file

object SparkHiveMetaStoreMasterHelloWorld extends  App {

    // spark shall use for meta data store by default
    // shall use default hive config, initialize meta store etc
    // property setting
    // if not set, it uses SPARK_HOME
    val warehouseLocation = new File("spark-warehouse").getAbsolutePath

    println("PAth " + warehouseLocation)

    val spark = SparkSession
      .builder()
     // .master("local[1]")           // master can be given from command line
      .appName("Spark Hive Example")
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .config("hive.metastore.uris", "thrift://localhost:9083")
      .enableHiveSupport()
      .getOrCreate()


    import spark.sql

    sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING) USING hive")
    // While using HIVE on Spark, map-reduce engine is not used
   sql("INSERT INTO TABLE src values (11, 'ELEVEN')")
    sql("INSERT INTO TABLE src values (7, 'SEVEN')")

    sql("SELECT * FROM src").show()
}
