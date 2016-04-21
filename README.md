#PhysP
> A programming language for solving basic physic problems.

## Documentation
### Data Types
#### Vector
* Magnitude
* Angle
* X Component
* Y Component

#### Object
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

### Measurements
####Force
* N : Newtons
* pound : pounds force

####Time
* s : seconds
* min : minutes
* hr : hours

####Distance
* cm : centimeters
* m : meters
* km : kilometers
* in : inches
* ft : feet
* mi : miles

####Velocity
* cm/s : centimeters per second
* m/s : meters per second
* km/hr : kilometers per hour
* ft/s : feet per second
* ft/min : feet per minute
* mi/hr : miles per hour

####Acceleration
* cm/s^2 : centimeters per seconds squared
* m/s^2 : meters per seconds squared
* km/hr^2 : kilometers per hours squared
* ft/s^2 : feet per seconds squared
* ft/min^2 : feet per minutes squared
* mi/hr^2 : miles per hours squared

####Angle
* degrees : degrees
* radians : radians

### Commands
*  Create objects or vectors <br />
`define <name> as <datatype>`
*  Assign attributes to objects <br />
`<name> with <attribute> <value><measurement>`
* Display or calculate attributes of objects <br />
`return <name> <attribute> in <measurement>`
* Make comparisons between object attribute and value <br />
`is <name> <attribute> <comparison> <value>`
* Remove previously declared objects <br />
`remove <name>`

##Requirements
1. Have Java installed on your machine, found [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

> To verify installation write the following in a terminal or command prompt

```bash
$ java -version
```

>If installed your Java version will appear

##Building
1. Extract project folder.
2. Open a terminal or command prompt inside project folder.
3. Run these commands to build the language.
```bash
cd src
java -cp javacc.jar javacc PhysP.jj
```
```bash
javac *.java
```

##Running
1. Run the following command to run the language in the terminal or command prompt.
```bash
java PhysParser
```

##Authors
* Stephan Elias Remy
* Mario Orbegoso
* Giovanni Gardon