val df = spark.read.csv("file:///Users/krish/workshops/scala-workshop/inputs/zipcodes.csv")

df.printSchema()

df.show()

val df2 = df.select("_c1", "_c2")

val df3 = df2.filter("_c1 is not null").filter("_c2 is not null").filter("_c2 = 'KL'")

-------


 val df = spark.read.option("header", "true").csv("file:///Users/krish/workshops/scala-workshop/inputs/zipcodes-header.csv")
df.printSchema()
df.show()

--

val df = spark.read.csv("file:///Users/krish/workshops/scala-workshop/inputs/sales.csv")

df.printSchema()

df.show()

val df2 = df.select("_c1", "_c2")

val df3 = df2.filter("_c1 is not null").filter("_c3 is not null").filter("_c3 = 'mobile'")

 val df = spark.read.option("header", "true").csv("file:///Users/krish/workshops/scala-workshop/inputs/sales-header.csv")
df.printSchema()
df.show()

val df3 = df2.filter("category is not null").filter("state is not null").filter("category = 'mobile'")


val df = spark.read.option("header", "true").option("inferSchema", "true").csv("file:///Users/krish/workshops/scala-workshop/inputs/sales-header.csv")
df.printSchema()
df.show()

 df.filter ("price <= 50000").show()

----

// RDD code to DF

case class ZipCode(area: String, pincode: String, state: String)

val textFile = sc.textFile("file:///Users/krish/workshops/scala-workshop/inputs/zipcodes.csv")

val pincodeRdd = textFile.map ( line => line.trim() ).filter(line => !line.isEmpty() ).map(line => line.split(",")).map (arr => ZipCode(arr(0), arr(1), arr(2)));

pincodeRdd.foreach(println)

val df = pincodeRdd.toDF()

df.printSchema()
df.show()

df.filter("state = 'KL'").show()


val results = df.filter("state = 'KL'")


results.write.format("csv").save("file:///Users/krish/workshops/scala-workshop/outputs/zipcodes-df")



results.write.format("csv").option("header","true").save("file:///Users/krish/workshops/scala-workshop/outputs/zipcodes-df")

 