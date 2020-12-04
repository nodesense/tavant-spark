https://github.com/nodesense/tavant-spark


https://github.com/nodesense/tavant-spark/tree/master/notes

https://github.com/nodesense/tavant-spark/blob/master/notes/Hadoop-Setup.md

https://raw.githubusercontent.com/nodesense/tavant-spark/master/notes/Hadoop-Setup.md



$HADOOP_HOME/sbin/start-all.sh



open a terminal


cd $HIVE_HOME

$HIVE_HOME/bin/hive --service metastore



open a new terminal


cd $HIVE_HOME

 $HIVE_HOME/bin/beeline -u jdbc:hive2://


open a new terminal

  cd $HIVE_HOME
  $HIVE_HOME/bin/hive



create table invoices(id STRING, amount INT);

insert into invoices values('1', 1000);
insert into invoices values('2', 2000);





do select query in either cli

select * from invoices;




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

    val spark = SparkSession
      .builder()
      .master("local[1]")           // master can be given from command line
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





--------------------------------------------------------

Spark Master 
    running on spark://yoursystemname:7077
    running on web http://localhost:8080 
    
    
    
    
    
Start the worker

sbt package

Submit the job via driver program





$SPARK_HOME/sbin/stop-slave.sh
$SPARK_HOME/sbin/stop-master.sh





open a terminal

$SPARK_HOME/sbin/start-master.sh

open another terminal for worker


hostname

$SPARK_HOME/sbin/start-slave.sh spark://yourhostname:7077



open browser and check localhost:8080

check if the worker is present or not



open new terminal


$SPARK_HOME/bin/spark-shell --master spark://yourhostname:7077




in intellji, click on sbt shell window on bottom side


package


open a new terminal


cd tavant-spark

$SPARK_HOME/bin/spark-submit --master spark://sense:7077  --class workshop.SparkHiveMetaStoreInvoices  target/scala-2.11/scala-workshop_2.11-0.1.jar






















