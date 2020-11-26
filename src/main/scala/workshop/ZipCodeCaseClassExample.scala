package workshop

import org.apache.spark.{SparkConf, SparkContext}

object ZipCodeCaseClassExample extends  App {
  // Domain object
  // POJO - Plain Old Java Object
  // Bean class
  case class ZipCode(area: String, pincode: String, state: String)


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
                          .map (arr => ZipCode(arr(0), arr(1), arr(2))) // creating case class instance
                          // rdd changes to case class collection
                          .filter(zipCode => zipCode.state == "KA")
                          .map(zipCode => zipCode.pincode) ; // select pin code

  pincodes.foreach(println)

  pincodes.saveAsTextFile(Util.getOutputPath("zipcodes2"))

}


