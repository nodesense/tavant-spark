package workshop

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Column


object SalesSparkSQL extends  App {
  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("Zipcode")
    .getOrCreate()

  import spark.implicits._

  val df = spark.read.option("header", true)
    .option("inferSchema", true) //columns are area,pincode,state
    .csv(Util.getInputPath("sales-header.csv"))

  df.createOrReplaceTempView("sales")
  val resultDf = spark.sql("select category, sum(price) as sum from sales group by category")


  resultDf
    .write
    .format("csv")
    .option("header","true")
    .mode("overwrite") // overwrite
    .save(Util.getOutputPath("sales-category-aggergate"));

  spark.close();

}
