package workshop.dataframe

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{ArrayType, IntegerType, MapType, StringType, StructType}
import org.apache.spark.sql.functions._
object WithColumn {

  def main(args:Array[String]):Unit= {

    val spark: SparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate()


    val arrayStructureData = Seq(
      Row(Row("James ","","Smith"), // column 1 with structured data
        "1", // column 2
        "M", // column 3
        3100,
        List("Cricket","Movies"), // column wiht list
        Map("hair"->"black","eye"->"brown") // column with map
      ),
      Row(Row("Michael ","Rose",""),"2","M",3100,List("Tennis"),Map("hair"->"brown","eye"->"black")),
      Row(Row("Robert ","","Williams"),"3","M",3100,List("Cooking","Football"),Map("hair"->"red","eye"->"gray")),
      Row(Row("Maria ","Anne","Jones"),"4","M",3100,null,Map("hair"->"blond","eye"->"red")),
      Row(Row("Jen","Mary","Brown"),"5","M",3100,List("Blogging"),Map("white"->"black","eye"->"black"))
    )

    // autopopulate schema inferSchema, build a schema inspecting the csv

    // creating a structure
    val arrayStructureSchema = new StructType()
      .add("name", // structure, that contains
                new StructType()
                  .add("firstname",StringType)
                  .add("middlename",StringType)
                  .add("lastname",StringType)
        )
      .add("id",StringType)
      .add("gender",StringType)
      .add("salary",IntegerType)
      .add("Hobbies", ArrayType(StringType))
      .add("properties", MapType(StringType,StringType))

    val df2 = spark.createDataFrame(
                  spark.sparkContext.parallelize(arrayStructureData),
                  arrayStructureSchema)

    //Change the column data type
    df2.withColumn("salary",df2("salary").cast("Integer"))

    //Derive a new column from existing
    val df4=df2.withColumn("CopiedColumn",df2("salary")* -1)
    println("***** With CopiedColumn");
    df4.printSchema();

    //Transforming existing column
    val df5 = df2.withColumn("salary",df2("salary")*100)
    println("***** With df5 * 100");
    df5.printSchema();

    //You can also chain withColumn to change multiple columns

    //Renaming a column.
    val df3=df2.withColumnRenamed("gender","sex")
    println("Column Renamed");
    df3.printSchema()

    //Droping a column
    val df6=df4.drop("CopiedColumn")

    println(df6.columns.contains("CopiedColumn"))

    //Adding a literal value
    println("Literal USA");
   df2.withColumn("Country", lit("USA")).printSchema()
   // Print data

    //Retrieving
    df2.show(false)

    // returns the whole struct firstname, middle, lastname
    println("**name")
    df2.select("name").show(false)

    // returns a string which contains value of name.firstname
    println("**name.firstname")
    df2.select("name.firstname").show(false)
    // return all
    println("**name.*")

    // return 20 default
    df2.select("name.*").show(true)


    val df8 = df2.select(col("*"),explode(col("hobbies")))
    df8.show(false)

    import spark.implicits._

    val columns = Seq("name","address")
    val data = Seq(("Robert, Smith", "1 Main st, Newark, NJ, 92537"),
                   ("Maria, Garcia","3456 Walnut st, Newark, NJ, 94732"))

    var dfFromData = spark.createDataFrame(data).toDF(columns:_*)
    dfFromData.printSchema()

    // contains 6 columns
    // column name?? _c0, _c1
    val newDF = dfFromData.map(f=>{
      // nameSplit => ("Robert", "Smith")
      val nameSplit = f.getAs[String](0).split(",")
      // addSplit ("3456 Walnut st", "Newark", "NJ", "94732")
      val addSplit = f.getAs[String](1).split(",")
      (nameSplit(0),nameSplit(1),addSplit(0),addSplit(1),addSplit(2),addSplit(3))
    })

    println("***newDF schema")
    newDF.printSchema()

    // col names shall "First Name", "Last Name" .....
    val finalDF = newDF.toDF("First Name","Last Name","Address Line1","City","State","zipCode")
    println("***finalDF schema")
    finalDF.printSchema()
    finalDF.show(false)
  }
}
