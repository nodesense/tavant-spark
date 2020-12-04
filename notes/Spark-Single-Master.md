move spark to /opt/spark

sudo mv spark-2.4.7 /opt/spark

open terminal, in home director

nano .bashrc

paste below command

export SPARK_HOME=/opt/spark


open terminal, in home director

nano .bashrc

paste below command

export SPARK_HOME=/opt/spark

Ctrl + O
Ctrl + X


open new terminal

How to start spark master program, spark shall run in separate process
Driver will be running in separate program


$SPARK_HOME/sbin/start-master.sh




 tail /opt/spark/logs/spark-krish-org.apache.spark.deploy.master.Master-1-sense.out

tail <<the spark log file path>>


20/12/04 12:10:34 INFO Utils: Successfully started service 'sparkMaster' on port 7077.
20/12/04 12:10:34 INFO Master: Starting Spark master at spark://sense:7077
20/12/04 12:10:34 INFO Master: Running Spark version 2.4.7
20/12/04 12:10:34 INFO Utils: Successfully started service 'MasterUI' on port 8080.
20/12/04 12:10:34 INFO MasterWebUI: Bound MasterWebUI to 0.0.0.0, and started at http://192.168.1.2:8080
20/12/04 12:10:34 INFO Master: I have been elected leader! New state: ALIVE



SPARK MASTER running on spark://sense:707
MasterWebUI to 0.0.0.0, and started at http://192.168.1.2:8080



---
To spark master,

$SPARK_HOME/sbin/stop-master.sh

------


Now start 1 instance of spark worker


$SPARK_HOME/sbin/start-slave.sh spark://sense:7077


this output

starting org.apache.spark.deploy.worker.Worker, logging to /opt/spark/logs/spark-krish-org.apache.spark.deploy.worker.Worker-1-sense.out




tail  /opt/spark/logs/spark-krish-org.apache.spark.deploy.worker.Worker-1-sense.out

tail <<worker log path >>


To stop the slave


$SPARK_HOME/sbin/stop-slave.sh




$SPARK_HOME/sbin/start-slave.sh spark://sense:7077

$SPARK_HOME/sbin/start-slave.sh spark://<<hostname>>:7077


tail <<worker log path >>


check the browser and see if 1 worker is registered, [refresh]

http://localhost:8080/







open a terminal

hostname



$SPARK_HOME/bin/spark-shell --master spark://sense:7077

$SPARK_HOME/bin/spark-shell --master spark://<<hostname>>:7077


Check and refresh in the browser http://localhost:8080

and see the spark shell is connected



spark-shell is a driver program, this submit

  some commands to spark master --> master allocate the  worker

 spark-shell/driver shall submit the work to worker


$SPARK_HOME/bin/spark-shell --master spark://sense:7077




val numbers = sc.parallelize(Seq(10, 20, 30,40,50))

 numbers.sum()


----

Now remember sbt package, it produce a file in the target


in sbt 

do 

> package 


after success message

open new terminal


cd tavant-spark

$SPARK_HOME/bin/spark-submit --master spark://sense:7077  --class workshop.SparkHiveMetaStoreMasterHelloWorld  target/scala-2.11/scala-workshop_2.11-0.1.jar

check the localhost:8080

check in hive 

select * from spec;

