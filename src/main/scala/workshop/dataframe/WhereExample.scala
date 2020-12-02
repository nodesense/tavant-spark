package workshop.dataframe

import org.apache.spark.sql.functions.array_contains
import org.apache.spark.sql.types.{ArrayType, StringType, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object WhereExample extends App{

  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val arrayStructureData = Seq(
    Row(Row("James","","Smith"),List("Java","Scala","C++"),"OH","M"),
    Row(Row("Anna","Rose",""),List("Spark","Java","C++"),"NY","F"),
    Row(Row("Julia","","Williams"),List("CSharp","VB"),"OH","F"),
    Row(Row("Maria","Anne","Jones"),List("CSharp","VB"),"NY","M"),
    Row(Row("Jen","Mary","Brown"),List("CSharp","VB"),"NY","M"),
    Row(Row("Mike","Mary","Williams"),List("Python","VB"),"OH","M")
  )

  val arrayStructureSchema = new StructType()
    .add("name",new StructType()
      .add("firstname",StringType)
      .add("middlename",StringType)
      .add("lastname",StringType))
    .add("languages", ArrayType(StringType))
    .add("state", StringType)
    .add("gender", StringType)

  val df = spark.createDataFrame(
    spark.sparkContext.parallelize(arrayStructureData),arrayStructureSchema)
  df.printSchema()
  df.show()

  //Condition
  // scala condition
  // pick column state from dataframe and filter with if state == "OH" in scala construct
  // option to write low level code
  df.where(df("state") === "OH")
    .show(false)

  //SQL Expression
  // Use SQL Engine / catalizt engine to perform the check
  // SQL part select * from mytable where gender='M'
  // sql level code / high level
  df.where("gender == 'M'")
    .show(false)

  //multiple condition
  // scala
  df.where(df("state") === "OH" && df("gender") === "M")
    .show(false)

  //Array condition
  // scala
  df.where(array_contains(df("languages"),"Java"))
    .show(false)

  //Struct condition
  // scala
  df.where(df("name.lastname") === "Williams")
    .show(false)

}
