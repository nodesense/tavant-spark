
Hive-on-MR is deprecated in Hive 2 and may not be available in the future versions. Consider using a different execution engine (i.e. spark, tez) or using Hive 1.X releases.

Spark

Hive

Hadoop FS [DFS/HDFS]


Spark Driver -> Hive -> Hadoop DFS
          analytics using MR


Spark Driver --> Hive --> Spark Framework for Analytics --> HDFS
 + 
Spark SQL

+ Apache Beam [Unifies spark/flink] [.net, go java..., python]