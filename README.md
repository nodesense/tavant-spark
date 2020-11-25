
```
sudo apt install openjdk-8-jdk -y

sudo nano /etc/environment

Paste below content 

JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
JRE_HOME=/usr/lib/jvm/java-8-openjdk-amd64
PATH="/usr/lib/jvm/java-8-openjdk-amd64/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games"

Ctrl + O - to save file

Ctrl + X - to exit

To apply environemnt,  or restart vm

sed 's/^/export /' /etc/environment > /tmp/env.sh && source /tmp/env.sh

java -version

javac -version

echo $JAVA_HOME
echo $JRE_HOME

```


```
match case / switch

Function **

Companion Object
try / catch -- error handling

Either
Try, Success
Future
Option
Collections 
```

## Linux

```
  ssh root@ipaddress

  apt update
  apt upgrade
     
  sudo apt install openjdk-8-jdk -y
  
  sudo nano /etc/environment
  
  Paste below content 
  
  JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
  JRE_HOME=/usr/lib/jvm/java-8-openjdk-amd64
  PATH="/usr/lib/jvm/java-8-openjdk-amd64/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games"
  
  
  Ctrl + O - to save file
  
  Ctrl + X - to exit
```


## Hadoop 2.7.7

```
wget https://archive.apache.org/dist/hadoop/common/hadoop-2.7.7/hadoop-2.7.7.tar.gz

tar xf hadoop-2.7.7.tar.gz

sudo nano /etc/environment

place below settings into environment files

HADOOP_HOME=/root/hadoop-2.7.7
HADOOP_INSTALL=/root/hadoop-2.7.7
HADOOP_MAPRED_HOME=/root/hadoop-2.7.7
HADOOP_COMMON_HOME=/root/hadoop-2.7.7 
HADOOP_HDFS_HOME=/root/hadoop-2.7.7 
YARN_HOME=/root/hadoop-2.7.7
HADOOP_COMMON_LIB_NATIVE_DIR=/root/hadoop-2.7.7/lib/native
HADOOP_PREFIX=/root/hadoop-2.7.7

```

reboot the vm

```
export PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin
```

```

cp $HADOOP_HOME/etc/hadoop/core-site.xml $HADOOP_HOME/etc/hadoop/core-site.xml.bak
cp $HADOOP_HOME/etc/hadoop/hdfs-site.xml $HADOOP_HOME/etc/hadoop/hdfs-site.xml.bak
cp $HADOOP_HOME/etc/hadoop/mapred-site.xml.template $HADOOP_HOME/etc/hadoop/mapred-site.xml.bak
cp $HADOOP_HOME/etc/hadoop/yarn-site.xml $HADOOP_HOME/etc/hadoop/yarn-site.xml.bak


```

nano core-site.xml

paste below content

```


<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>

<configuration>
<property>
<name>fs.defaultFS</name>
<value>hdfs://localhost:9000</value>
</property>
<property>
<name>hadoop.tmp.dir</name>
<value>/data/hdfs</value>
</property>
</configuration>
```


nano hdfs-site.xml

paste below

```
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>

<configuration>
    <property>
    <name>dfs.replication</name>
    <value>1</value>
    </property>
</configuration>
```


```
mv mapred-site.xml.template  mapred-site.xml

```


```
    nano mapred-site.xml
```

```
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
    <property>
    <name>mapreduce.framework.name</name>
    <value>yarn</value>
    </property>
</configuration>
```

```
nano yarn-site.xml
```

```

<configuration>
    <property>
    <name>yarn.nodemanager.aux-services</name>
    <value>mapreduce_shuffle</value>
    </property>
    <property>
    <name>yarn.nodemanager.aux-services.mapreduce.shuffle.class</name>
    <value>org.apache.hadoop.mapred.ShuffleHandler</value>
    </property>
</configuration>
```


## Setup Hadoop Security

```
ssh-keygen -t rsa -P ""

press enter key


```



Spark 2.4.7
Hadoop 2.7 x

