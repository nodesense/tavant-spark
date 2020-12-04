https://www.scala-sbt.org/download.html



open terminal

nano .bashrc


paste the line

export PATH=$PATH:/home/username/sbt/bin




Ctrl + O

Ctrl + X



open new terminal, change directory where the project is located


cd tavant-spark


ls 


ensure that build.sbt is present

then start the sbt shell command


sbt


>   compile 


the above command compile scala source 


> run 


the above command shall display all the scala programs that contains main function extends from App
pick a program to run, and enter the program number, then it will execute


> package 

the above command shall create a jar, jar file is nothing but a collection of classes, resources  into single file.
jar is a zip file


> clean 

clean command clear the compiled class files so that we can ensure that all fieles properly compiled later, no cache issues

