Commond hive - start the cli, sql statements
it won't start the server for other program to interact

----

we need to start meta service so that spark can connect


add below to hive-site.xml

 <property>
    <name>hive.metastore.uris</name>
    <value>thrift://localhost:9083</value>
  </property>
  
<property>
    <name>hive.server2.enable.doAs</name>
    <value>false</value>
</property>
   
-----

To start hive meta store service on port 9083, spark can connect to 9083

cd $HIVE_HOME
$HIVE_HOME/bin/hive --service metastore


now metastore is listening on port 9083, keep this running

----

HIVE CLI
cd $HIVE_HOME
$HIVE_HOME/bin/hive


SPARK/Other programs, JDBC, Scala/Java, JDBC to connect DB

beeline start the jdbc connection

open new terminal, you can susbctitue host/db/password if other host

cd $HIVE_HOME
 $HIVE_HOME/bin/beeline -u jdbc:hive2://
 



create table invoices(id STRING, amount INT);

insert into invoices values('1', 1000);
insert into invoices values('2', 2000);





do select query in either cli

select * from invoices;








