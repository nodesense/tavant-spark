package workshop
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object ZipCodeExample extends  App {
  val conf = new SparkConf()
    .setMaster("local[1]")
    .setAppName("WordCountApp")

  val sc = new SparkContext(conf)
  //sc.setLogLevel("error")
  val textFile = sc.textFile(Util.getInputPath("zipcodes.csv"))

  val pincodes = textFile
                          .map ( line => line.trim() ) // remove space front and back of the string
                          .filter(line => !line.isEmpty() ) // do not process empty lines
                          .map(line => line.split(",")) // return array (area,pincode,state)
                          .filter( arr => arr(2) == "TN") // Array
                          .map(arr => arr(1)) // String

  pincodes.foreach(println)

  pincodes.saveAsTextFile(Util.getOutputPath("zipcodes"))

}
