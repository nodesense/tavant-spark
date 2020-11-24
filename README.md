
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