# PhysP
> A programming language for solving basic physic problems.

## Documentation
### Data Types
#### Vector
   > Force vectors
   
   * Magnitude
   * Angle
   * X Component
   * Y Component

#### Object
   > Point in space, mass, gravity nor friction is considered

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
#### Force
   > Applicable to `Magnitude`, `X Component`, and `Y Component` attributes
   
   * N : Newtons
   * pounds : pounds force

#### Time
   > Applicable to `Initial Time`, `Final Time`, and `Time Moved` attributes

   * s : seconds
   * min : minutes
   * hr : hours

#### Distance
   > Applicable to `Initial Position`, `Final Position`, and `Displacement` attributes

   * cm : centimeters
   * m : meters
   * km : kilometers
   * in : inches
   * ft : feet
   * mi : miles

#### Velocity
   > Applicable to `Initial Velocity`, `Final Velocity`, and `Average Velocity` attributes

   * cm/s : centimeters per second
   * m/s : meters per second
   * km/hr : kilometers per hour
   * ft/s : feet per second
   * ft/min : feet per minute
   * mi/hr : miles per hour

#### Acceleration
   > Applicable to `Acceleration` attribute

   * cm/s^2 : centimeters per seconds squared
   * m/s^2 : meters per seconds squared
   * km/hr^2 : kilometers per hours squared
   * ft/s^2 : feet per seconds squared
   * ft/min^2 : feet per minutes squared
   * mi/hr^2 : miles per hours squared

#### Angle
   > Applicable to `Angle` attribute

   * degrees : degrees
   * radians : radians

### Comparisons
> Used for comparing numeric values

* equal to : Compares whether the two values are the same
* not equal to : Compares whether the two values are not the same
* greather than : Compares whether the first value is greater than the second value
* greater than or equal to : Compares whether the first value is greater than the second value or equal
* less than : Compares whether the first value is less than the second value
* less than or equal to : Compares whether the first value is less than the second value or equal

### Commands
> `name` : Must start with lowercase letter followed by combination of letter, number or underscore <br />
> `datatype` : View above for details
> `attribute` : Specfic attribute that belongs to <datatype> of <name>, view above for details <br />
> `value` : Must be valid numeric value <br />
> `measurement` : Applicable measurement for <attribute>, view above for details <br />
> `comparison` : View above for details

*  Create objects or vectors
   * `define <name> as <datatype>`
*  Assign attributes to objects
   * `<name> with <attribute> <value><measurement>`
* Display or calculate attributes of objects
   * `return <name> <attribute> in <measurement>`
* Make comparisons between object attribute and value
   * `is <name> <attribute> <comparison> <value>`
* Remove previously declared objects
   * `remove <name>`
* Terminate the Parser
   * `Terminate`

## Requirements
1. Have Java installed on your machine, found [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
> To verify installation write the following in a terminal or command prompt, if installed your Java version will appear
```bash
   $ java -version
```

## Building
1. Extract project folder.
2. Open a terminal or command prompt inside project folder.
3. Run these commands to build the language.
```bash
  cd src
  java -cp javacc.jar javacc PhysP.jj
  javac *.java
```

## Running
* Run the following command to run the language in the terminal or command prompt.
```bash
  java PhysParser
```
* To execute code from a text file fun the following command.
```bash
  java PhysParser `filepath\filename.txt`
```

## Authors
* Stephan Elias Remy
* Mario Orbegoso
* Giovanni Gardon