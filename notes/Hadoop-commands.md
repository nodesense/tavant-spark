Hadoop Commands

open new terminal, in home directory

To know whether hadoop is runnning or not, 



jps


to list all files in the hadoop root directory [NOT LINUX]

hdfs dfs -ls /
 


to create directory in hadoop mkdir


hdfs dfs -mkdir /test


to check whether test is created or not

hdfs dfs -ls /


To create empty file [name node, may not impact data node]

hdfs dfs -touchz  /test/greetings.txt


hdfs dfs -ls /test

-----

Put the file content into hadoop

mkdir mydata

cd mydata

touch order1.csv

echo "10,20,30,40" >> order1.csv
echo "100,200,300,400" >> order1.csv


cat order1.csv



To copy local file like order1.csv into hadoop directory, running the command in mydata directory wehre order1.csv present


hdfs dfs -copyFromLocal order1.csv /test


To print data in the hadoop file system

hdfs dfs -cat /test/order1.csv


--- Excercise ----

create order2.csv, add some content put into hdfs and use cat command to display teh content


--------

to copy files from hadoop to local fiel system

hdfs dfs -copyToLocal /test/order1.csv  ./order-hdfs.csv




ls

cat order-hdfs.csv




to check how much space used by hadoop directories

hdfs dfs -du /





https://www.tutorialspoint.com/hadoop/hadoop_command_reference.htm
https://www.geeksforgeeks.org/hdfs-commands/














