package workshop

// SparkSession is new one, integrate all context like SparkContext, SQLContext, HiveContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Column

object ZipCodeDataFrameExample extends  App {
  val spark: SparkSession = SparkSession.builder()
                            .master("local[1]")
                            .appName("Zipcode")
                            .getOrCreate()

  import spark.implicits._

  val df = spark.read.option("header", true)
                       .option("inferSchema", true) //columns are area,pincode,state
                      .csv(Util.getInputPath("zipcodes-header.csv"))

  // val resultsDF = df.filter("state = 'KA' ")
  // $ is basically returns a Column object
  val cPinCode: Column = $"pincode"
  val cPinCode2: Column = col("pincode")
  val resultsDF = df.filter($"pincode" < 60000)

  //df.filter($"state" === "test")
  // df.filter($"state" !== "test")
  //df.filter(col("state") === "test")


  resultsDF
      .write
      .format("csv")
      .option("header","true")
      .mode("overwrite") // overwrite
      .save(Util.getOutputPath("zipcodes-df2"));

  spark.close();
}
