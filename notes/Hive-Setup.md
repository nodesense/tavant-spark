https://archive.apache.org/dist/hadoop/common/hadoop-2.7.7/hadoop-2.7.7.tar.gzopen terminal

be in home directory /home/username



```
wget https://downloads.apache.org/hive/hive-2.3.7/apache-hive-2.3.7-bin.tar.gz
wget http://archive.apache.org/dist/db/derby/db-derby-10.4.2.0/db-derby-10.4.2.0-bin.tar.gz

tar xf apache-hive-2.3.7-bin.tar.gz
mv apache-hive-2.3.7-bin apache-hive-2.3.7

tar xf  db-derby-10.4.2.0-bin.tar.gz
mv db-derby-10.4.2.0-bin     db-derby-10.4.2.0
```

----------------------
open in browser, 

save as  /home/<<username>>/apache-hive-2.3.7/conf/hive-site.xml


```
https://raw.githubusercontent.com/nodesense/kafka-workshop/master/hadoop/hive-site.xml
```

OR copy through wget command


open terminal run below

```
wget -P $HIVE_HOME/conf https://raw.githubusercontent.com/nodesense/kafka-workshop/master/hadoop/hive-site.xml
```

-------
```
cd apache-hive-2.3.7


$HIVE_HOME/bin/schematool -initSchema -dbType derby
```

ls


Then check if metastore_db folder there


-------------

Start the hive cli 

```
$HIVE_HOME/bin/hive
```

You will see a prompt hive>

```
hive> show tables;


to create database, you have two options, create database/schema



hive> SHOW DATABASES;


hive > CREATE DATABASE ordersdb;


hive> SHOW DATABASES;


hive> CREATE TABLE IF NOT EXISTS brands(id INT, name STRING);

hive> INSERT INTO brands(id,name) values(1, 'Apple');

hive> SELECT * from brands;



```



Follow this https://www.tutorialspoint.com/hive/hive_built_in_functions.htm  and practice all the sql possible





















