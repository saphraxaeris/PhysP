#PhysP
> A programming language for solving basic physic problems.

##Documentation
###Data Types
####Vector
* Magnitude
* Angle
* X Component
* Y Component
####Object
* Initial Position
* Final Position
* Displacement
* Initial Velocity
* Final Velocity
* Average Velocity
* Initial Time
* Final Time
* Time Moved
* Acceleration

###Commands
*  Create objects or vectors
`define <name> as <datatype>`
*  Assign attributes to objects
`<name> with <attribute> <value>`
* Display or calculate attributes of objects
`return <name> <attribute>`
* Make comparisons between object attribute and value
`is <name> <attribute> <comparison> <value>`
* Remove previously declared objects
`remove <name>`

##Requiremnts
1. Have Java installed on your machine, found [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html )
>To verify installation write the following in a terminal or command prompt
```bash
$ java -version
```
>If installed your Java version will appear

##Running
1. Open a terminal or command prompt on the folder where the .jj file is along with the javacc.jar file is.
2. Run these commands to build the language
```bash
java -cp "path to javacc.jar" javacc "path to PhysP.jj"
```
```bash
javac *.java
```
3. Run the following command to run the language in the terminal or command prompt
```bash
java PhysParser
```