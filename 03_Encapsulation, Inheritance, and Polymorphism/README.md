# Workshop 03 & 04 : Encapsulation and Abstraction, Inheritance, Polymorphism, and Exceptions.

## Objectives
* Familiar with implementing Inheritance, Polymorphism, Abstraction(Interface)
* Read text file using `BufferedReader`
* Implement custome `Exception`
* Creating and treating *2-D array*
* Cutomize display *number formmating*

## Outline
### Read a text file
* To read a text file, create an object of BufferedReader class 
```
BufferedReader br = new BufferedReader(new FileReader("shapes.txt"));
```
* If the file is not found, it is treated using `FileNotFoundException`
* Read each line till the end of file, and validate input(each line) and call exception when the input meets exception handling condition
```
try {
    br = new BufferedReader(new FileReader("shapes.txt"));
    while ((line = br.readLine()) != null) {      // continue to read till the end of line
        String[] tokens = line.split(",");  // Split string to words using delimiter(,)
        // Validate input and call exception when the input meets exception handling condition
        try {
            // Call the method validate in InputManager class by passing "tokens"
            // If the input (i.e., tokens) satisfies input requirements, it returns true, otherwise false
            if ((InputManager.validate(tokens, false))) {
                // Insert a valid input "token" array to storedShapes array as a new row
                // In this assignment, we store all valid Shape inputs by inserting valid input to storedShapes array
                // In turns, we use only one 2-D array!
                storedShapes = Utils.InsertRow(storedShapes, tokens);
            }
        } catch (WrongValueException exceptionMsg) {
            // catch the customized exception message and print it
            System.out.println(exceptionMsg.getMessage());
        }
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```
* Insert valid line to the end of 2D array
```
public static String[][] InsertRow(String[][] storedShapes, String[] tokens) {
    String[][] result = new String[storedShapes.length+1][];
    for(int i = 0; i < storedShapes.length; i++){
        result[i] = storedShapes[i];
    }
    result[storedShapes.length] = tokens;
    return result;
}
```

### Custom Exception handling
* When the input does not meet input requirement (e.g., all input values are positive), the program throws exception
```
if(Utils.isAllPositive(slice))
    isValid = true;
else
    throw new WrongValueException("Invalid side(s)!");
```
    * Customize exception handler
```
public class WrongValueException extends Exception{
    public WrongValueException(String message) {
        super(message);
    }
}
```

### Polymorphism
* In this workshop, I create various shapes object having common goal(i.e, calculating perimeter)
    * Circle, Rectangular, Parallelogram, Square, Triagle
* First, implement the interface `Shape` having *abstract* method `perimeter()`
```
@FunctionalInterface
public interface Shape {
    double perimeter();
}
```
* For each shape classe, override the abstract perimeter method
    * Example: Circle class
```
@Override
public double perimeter() {
    return (2 * Math.PI * getRadius());
}
```
* Because `Square` and `Parallelogram` is subset of `Rectangular`, these classes do not override `perimeter()` method

### Inheritance
* Because `Square` and `Parallelogram` is subset of `Rectangular`, these classes inherit the `Rectangular` class
```
public class Square extends Rectangle{
    public Square(double side) {
        super(side, side);
    }

    @Override
    public String toString() {
        NumberFormat df = Utils.displayFormat(perimeter());
        return this.getClass().getSimpleName() +
                " {s=" + getHeight() +
                "} perimeter = " + df.format(perimeter());
    }
}
```
* When executing the no-argument constructor of subClass, the no-argument constructor of superClass(i.e., 'Rectangular` class) is automatically called
    * So, there should be no-argument constructor in the `Rectangular` class

## Screenshot
* Link : https://github.com/chanlenium/Java/blob/main/03_Encapsulation%2C%20Inheritance%2C%20and%20Polymorphism/screenshot.pdf

## Important points about Inheritance and Polymorphism
* If you have at least one abstract method in your class, your class should be declared as "abstract". You can't create any objects based off an abstract class (since you have no implementations for at least one of its methods!) It's also possible that you declare a class as "abstract" even if you don't have any abstract methods in that class! The reason is simple; you want to use that class somewhere in an inheritance hierarchy (as a super-class) and so, be able to use polymorphism in your code.

* In an interface, all the methods are, by default, public abstract (and all the fields are by default public static final.) Classes that "implements" that interface should implement all those abstract methods or else, must be declared as "abstract".

* In Java, classes could "extends" just one super-class but could "implements" as many as interfaces as possible. Regardless, that class is considered to be a sub-class of that super-class and all those interfaces.

* "final" as a keyword, could be used for a variable (so that variable's value can't be changed later on), could be used for a method (which means that method can't be overridden in the sub-classes of this class), or could be used for a class (which means that class can't be extended or be used as a super-class in an inheritance hierarchy.)

* One famous interview Q would be the difference between abstract and final classes. The answer is you can't create an object based off an abstract class; it's just there to be inherited. On the other hand, you can't extend a "final" class but could create objects based off that.

* Another interview Q would be the difference between abstract classes and interfaces. One preliminary answer would be in an abstract class, there is this possibility that we have no abstract methods but in an interface, "all" the methods are abstract.
