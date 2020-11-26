package workshop

// SparkSession is new one, integrate all context like SparkContext, SQLContext, HiveContext
import org.apache.spark.sql.SparkSession

object ZipCodeDataFrameExample extends  App {
  val spark: SparkSession = SparkSession.builder()
                            .master("local[1]")
                            .appName("Zipcode")
                            .getOrCreate()

  val df = spark.read.option("header", true)
                       .option("inferSchema", true) //columns are area,pincode,state
                      .csv(Util.getInputPath("zipcodes-header.csv"))

  val resultsDF = df.filter("state = 'KA' ")

  resultsDF
      .write
      .format("csv")
      .option("header","true")
      .mode("overwrite") // overwrite
      .save(Util.getOutputPath("zipcodes-df2"));

  spark.close();
}
