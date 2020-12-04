package workshop

import java.io.File

import org.apache.spark.sql.SparkSession


// class path, FQN - Fully Qualified Name
// packge path + class name

// package best practices - com.tavant.busservice.SparkHiveMetaStoreMasterHelloWorld
// FQN workshop.SparkHiveMetaStoreMasterHelloWorld

// jar generated in the target/scala2.11 folder

// master running on spark://sense:7077

// SparkHiveMetaStoreInvoices is a driver program placed inside the jar file

object SparkHiveMetaStoreInvoices extends  App {

    // spark shall use for meta data store by default
    // shall use default hive config, initialize meta store etc
    // property setting
    // if not set, it uses SPARK_HOME
    val warehouseLocation = new File("spark-warehouse").getAbsolutePath

    println("PAth " + warehouseLocation)

  // comment out master when running in spark cluster
  // enable master local when running in local development
    val spark = SparkSession
      .builder()
      //.master("local[1]")           // master can be given from command line
      .appName("Spark Hive Example")
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .config("hive.metastore.uris", "thrift://localhost:9083")
      .enableHiveSupport()
      .getOrCreate()


    import spark.sql



    val df = sql("SELECT * FROM invoices")
    println("**show")
    df.show()
    println("**Schema")
    df.printSchema()

   val whereDf = df.where("amount <= 1500")
   println("**Where filter")
   whereDf.show();


  whereDf
    .write
    .format("csv")
    .option("header","true")
    .mode("overwrite") // overwrite
    .save("hdfs://localhost:9000/test/invoices-less-1500.csv");
}
