package shapes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;   // pointer to read a file
        String line;                // reference var to each line in a file
        int validInputCount = 0;    // var to store the number of valid inputs
        String[] storedShapes = {}; // array to contain all the shapes

        printHeader();

        try {
            br = new BufferedReader(new FileReader("shapes.txt"));
            while ((line = br.readLine()) != null) {      // continue to read till the end of line
                String[] tokens = line.split(",");  // Split string to words using delimiter(,)
                InputManager manager = new InputManager();// Create InputManager() object to validate input

                // Validate input and call exception when the input meets exception handling condition
                try {
                    // Call the method validate of object manager by passing "tokens"
                    // If the input (i.e., tokens) satisfies input requirements, it returns true, otherwise false
                    if ((manager.validate(tokens, false))) {
                        // Add a valid input "token" array to storedShapes array
                        // In this assignment, we store all valid Shape inputs by adding valid input to storedShapes array
                        // In turns, we use only one array!
                        storedShapes = Stream.concat(Arrays.stream(storedShapes), Arrays.stream(tokens))
                                .toArray(String[]::new);
                        validInputCount++;  // Increase the number of valid inputs
                    }
                } catch (WrongValueException exceptionMsg) {
                    // catch the customized exception message and print it
                    System.out.println(exceptionMsg.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(validInputCount > 0){ // Check there are valid inputs or not
            System.out.print("\n");
            System.out.println(validInputCount + ((validInputCount > 1)?" Shapes were created": "Shape was created"));

            int start = 0, end = 0;
            for(int i = 0; i < validInputCount; i++) {  // Investigate valid inputs
                if (storedShapes[start].equals("Circle")) {
                    // When the name of Shape(i.e., first element) is the "Circle", the number of value is 1(i.e., radius)
                    end = start + 1;    // set end point for the given Shape("Circle")
                    // slice elements for the given Shape("Circle") from the storedShapes array
                    String[] tokens = Utils.getSliceOfArray(storedShapes, start, end + 1);
                    // Generate polymorphism object shape (actual object is decided at run time)
                    Shape shape = new Circle(Double.parseDouble(tokens[1]));
                    System.out.println(shape.toString());   // print String for the given Shape("Circle")
                    start = end + 1;    // set next start point
                } else if (storedShapes[start].equals("Rectangle")) {
                    end = start + 2;    // set end point for the given Shape("Rectangle")
                    String[] tokens = Utils.getSliceOfArray(storedShapes, start, end + 1);
                    Shape shape = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                    System.out.println(shape.toString());
                    start = end + 1;
                } else if (storedShapes[start].equals("Parallelogram")) {
                    end = start + 2;    // set end point for the given Shape("Parallelogram")
                    String[] tokens = Utils.getSliceOfArray(storedShapes, start, end + 1);
                    Shape shape = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                    System.out.println(shape.toString());
                    start = end + 1;
                } else if (storedShapes[start].equals("Square")) {
                    end = start + 1;    // set end point for the given Shape("Parallelogram")
                    String[] tokens = Utils.getSliceOfArray(storedShapes, start, end + 1);
                    Shape shape = new Square(Double.parseDouble(tokens[1]));
                    System.out.println(shape.toString());
                    start = end + 1;
                } else if (storedShapes[start].equals("Triangle")) {
                    end = start + 3;
                    String[] tokens = Utils.getSliceOfArray(storedShapes, start, end + 1);
                    Shape shape = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                    System.out.println(shape.toString());
                    start = end + 1;
                }
                System.out.print("\n");
            }
        }else{
            System.out.println("No more valid input");
        }
    }

    private static void printHeader() {
        System.out.println("------->JAC 444 Workshop 03<-------");
        System.out.println("------->Task 1 ... <-------");
    }
}
