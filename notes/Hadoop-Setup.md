export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export JRE_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export HADOOP_HOME=/home/<<username>>/hadoop-2.7.7
export HIVE_HOME=/home/<<username>>/apache-hive-2.3.7
export DERBY_HOME=/home/<<username>>/db-derby-10.4.2.0
export HIVE_PORT=10000




open new terminal

echo $HADOOP_HOME

---

put below into .bachrc file, after the export statement, after HIVE_PORT


export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
export PATH=$PATH:$DERBY_HOME/bin
export PATH=$PATH:$HIVE_HOME/bin

export CLASSPATH=$CLASSPATH:$DERBY_HOME/lib/derby.jar:$DERBY_HOME/lib/derbytools.jar
export CLASSPATH=$CLASSPATH:$HADOOP_HOME/lib/*:.
export CLASSPATH=$CLASSPATH:$HIVE_HOME/lib/*:.


do this in new terminal


cp $HADOOP_HOME/etc/hadoop/core-site.xml $HADOOP_HOME/etc/hadoop/core-site.xml.original
cp $HADOOP_HOME/etc/hadoop/hdfs-site.xml $HADOOP_HOME/etc/hadoop/hdfs-site.xml.original
cp $HADOOP_HOME/etc/hadoop/mapred-site.xml $HADOOP_HOME/etc/hadoop/mapred-site.xml.original
cp $HADOOP_HOME/etc/hadoop/yarn-site.xml $HADOOP_HOME/etc/hadoop/yarn-site.xml.original


cd $HADOOP_HOME/etc/hadoop

ls


run this command in hadoop  directory

 > core-site.xml
 > hdfs-site.xml
 > yarn-site.xml



nano core-site.xml

paste the below content

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


Ctrl + O
Ctrl + X



nano hdfs-site.xml

paste below content

<configuration>
    <property>
    <name>dfs.replication</name>
    <value>1</value>
    </property>
</configuration>





Ctrl + O
Ctrl + X


nano yarn-site.xml

paste below content

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






Ctrl + O
Ctrl + X



nano mapred-site.xml

<configuration>
    <property>
    <name>mapreduce.framework.name</name>
    <value>yarn</value>
    </property>
</configuration>




Ctrl + O
Ctrl + X


For Data directory, create teh directory and assign all permission, not good for production


back to home directory
 
cd ~



sudo mkdir -p /data/hdfs

sudo chmod -R 777 /data/hdfs





Now, generate ssh token for autologin, the reason is hadoop shall ssh into their system, it expect a linux user without password to be present


do this in your home directory


ssh-keygen -t rsa -P ""

hit enter key for above command



cat $HOME/.ssh/id_rsa.pub >> $HOME/.ssh/authorized_keys


ssh localhost 

type yes and enter key

logout



if SSH not installed

sudo service ssh status



sudo apt install openssh-server

sudo systemctl status ssh




Format hdfs


ls /data/hdfs
hdfs namenode -format


ls /data/hdfs
start-all.sh
open browser, check http://localhost:50070
