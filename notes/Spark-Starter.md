touch input.txt

ls input.txt

echo "spark scala kafka" >> input.txt
echo "java scala akka" >> input.txt
echo "jvm java 1.8" >> input.txt


cat input.txt



sudo mv ~/spark-2.4.7 /opt/spark
cd /opt/spark
cd bin
./spark-shell




scala> val textFile = sc.textFile("file:///Users/krish/input.txt")

scala> textFile.count()

scala> textFile.first()



scala> val sparkFilter = textFile.filter(line => line.contains("spark"))

scala> sparkFilter.count()


val uppercaseRdd = textFile.map (line => line.toUpperCase())

scala> uppercaseRdd.first()

scala> textFile.collect()

Note: line.split(" ") returns array or words, map is emitting the array as is

scala> val words = textFile.map(line => line.split(" "))
words: org.apache.spark.rdd.RDD[Array[String]] = MapPartitionsRDD[5] at map at <console>:25

scala> words.first()
res12: Array[String] = Array(scala, spark, hadoop)

--
flatMap

line.split(" ") returns an array
convert array into element
(Scala, Spark, Hadoop) converts into Scala, Spark, Hadoop [Flattening the array]


scala> val words = textFile.flatMap(line => line.split(" "))
words: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[6] at flatMap at <console>:25

scala> words.first()
res13: String = scala



uppercaseRdd.saveAsTextFile("file:///Users/krish/output.txt")


 words.saveAsTextFile("file:///Users/krish/output-words")

do this as in bash shell, not in spark shell


cd output.txt

ls

cat _SUCCESS

cat part-00000

cat part-00001




scala> val wordCounts = textFile.flatMap(line => line.split(" ")).map (word => (word, 1)).reduceByKey( (acc, value) => acc + value)

scala> wordCounts.collect()


