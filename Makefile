JC = javac
JVM = java

#CP = ClassPath :: SP = SourcePath, all source files are at SP/**/*.java 
CP = bin
SP = src

#TCP = TestClassPath :: TSP = TestSourcePath, all test source files are at TSP/**/*.java
TCP = tbin
TSP = tests

# what runs on default when I type Make
default: fulllib

#compiles the lib and builds it into a jar
fulllib: buildlib libjar

#builds the source
buildlib:
	$(JC) $(SP)/**/*.java -d $(CP)

#cleans the bin and the .jar file
c: clean
clear: clean
clean:
	rm $(CP)/**/*.class 
	rmdir $(CP)/* 
	rmdir $(CP) || echo "No classpath to remove"
	rm PCG.jar || echo "No Jar file to remove"

#builds the library
libjar:
	jar cvfm PCG.jar MANIFEST.MF  -C bin .

