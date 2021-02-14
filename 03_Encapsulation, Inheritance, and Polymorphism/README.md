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
