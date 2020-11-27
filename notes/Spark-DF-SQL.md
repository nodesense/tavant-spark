
filter("fieldname = 'somevalue' )

 Optimizer - generate code at runtime, byte code, for JVM
 
SQL - DF
    execution engine - dynamic engine 
        code is converted to JVM byte code, fastest
        
1.x
        
RDD - fastest
DF  - Faster
SQL - Fast

2.x
 RDD - fastest
 DF/SQL - Faster - unified framework
    RDD -> DS -> Typed DF -> SQL
    
> /opt/spark/bin/spark-shell
>
>
  
  
  

val df = spark.read.option("header", "true").option("inferSchema", "true").csv("file:///Users/krish/workshops/scala-workshop/inputs/sales-header.csv")
df.printSchema()
df.show()

scala> df.createOrReplaceTempView("sales")

scala> spark.sql("select * from sales").show()
 
scala> spark.sql("select category, sum(price) from sales group by category").show()


 