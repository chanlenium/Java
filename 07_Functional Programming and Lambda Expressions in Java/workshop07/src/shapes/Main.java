package shapes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;   // pointer to read a file
        String line;                // reference var to each line in a file
        String[][] storedShapes = {}; // array to contain all the shapes
        Shape shape = null; // reference var to the polymorphic interface
        double minPerimeterOfTriangle = 99999;  // initial var to derive minimum perimeter of triangle
        double maxPerimeterOfCircle = -1;   // initial var to derive maximum perimeter of circle

        printHeaderTask1();
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

        //System.out.println(Arrays.deepToString(storedShapes));
        if(storedShapes.length > 0){ // Check there are valid inputs or not
            System.out.print("\n");
            System.out.println(storedShapes.length + ((storedShapes.length > 1)?" Shapes were created": "Shape was created"));

            for(int i = 0; i < storedShapes.length; i++) {
                switch (storedShapes[i][0]) {
                    case "Circle":
                        // Specify class type in run-time
                        shape = new Circle(Double.parseDouble(storedShapes[i][1]));
                        // calculate maximum perimeter of circle
                        maxPerimeterOfCircle = Math.max(shape.perimeter(), maxPerimeterOfCircle);
                        break;
                    case "Square":
                        shape = new Square(Double.parseDouble(storedShapes[i][1]));
                        break;
                    case "Rectangle":
                        shape = new Rectangle(Double.parseDouble(storedShapes[i][1]), Double.parseDouble(storedShapes[i][2]));
                        break;
                    case "Parallelogram":
                        shape = new Parallelogram(Double.parseDouble(storedShapes[i][1]), Double.parseDouble(storedShapes[i][2]));
                        break;
                    case "Triangle":
                        shape = new Triangle(Double.parseDouble(storedShapes[i][1]), Double.parseDouble(storedShapes[i][2]), Double.parseDouble(storedShapes[i][3]));
                        // calculate minimum perimeter of circle
                        minPerimeterOfTriangle = Math.min(shape.perimeter(), minPerimeterOfTriangle);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + storedShapes[i][0]);
                }
                //System.out.println(shape.toString());
                //System.out.print("\n");
            }
        }else{
            System.out.println("No more valid input");
        }

        printHeaderTask4();
        if(storedShapes.length > 0){ // Check there are valid inputs or not
            for(int i = 0; i < storedShapes.length; i++) {
                switch (storedShapes[i][0]) {
                    case "Circle":
                        shape = new Circle(Double.parseDouble(storedShapes[i][1]));
                        // Check the perimeter of current object is as same as the maxPerimeterOfCircle
                        if(!String.format(Utils.displayFormat(maxPerimeterOfCircle).format(maxPerimeterOfCircle)).equals(
                                String.format(Utils.displayFormat(shape.perimeter()).format(shape.perimeter()))
                        )){
                            System.out.printf("%s\n\n", shape.toString());
                        }else{
                            storedShapes = Utils.deleteRow(storedShapes, i--);
                        }
                        break;
                    case "Square":
                        shape = new Square(Double.parseDouble(storedShapes[i][1]));
                        System.out.printf("%s\n\n", shape.toString());
                        break;
                    case "Rectangle":
                        shape = new Rectangle(Double.parseDouble(storedShapes[i][1]), Double.parseDouble(storedShapes[i][2]));
                        System.out.printf("%s\n\n", shape.toString());
                        break;
                    case "Parallelogram":
                        shape = new Parallelogram(Double.parseDouble(storedShapes[i][1]), Double.parseDouble(storedShapes[i][2]));
                        // calculate total perimeter for the current Class type
                        ((Parallelogram)shape).setTotalParallelograms(((Parallelogram)shape).getTotalParallelograms() + shape.perimeter());
                        System.out.printf("%s\n\n", shape.toString());
                        break;
                    case "Triangle":
                        shape = new Triangle(Double.parseDouble(storedShapes[i][1]), Double.parseDouble(storedShapes[i][2]), Double.parseDouble(storedShapes[i][3]));
                        // Check the perimeter of current object is as same as the minPerimeterOfTriangle
                        if(!String.format(Utils.displayFormat(minPerimeterOfTriangle).format(minPerimeterOfTriangle)).equals(
                                String.format(Utils.displayFormat(shape.perimeter()).format(shape.perimeter()))
                        )){
                            System.out.printf("%s\n\n", shape.toString());
                            // calculate total perimeter for the current Class type
                            ((Triangle)shape).setTotalPerimeterOfTriangles(((Triangle)shape).getTotalPerimeterOfTriangles() + shape.perimeter());
                        }else{
                            storedShapes = Utils.deleteRow(storedShapes, i--);
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + storedShapes[i][0]);
                }
            }
        }else{
            System.out.println("No more valid input");
        }
    }

    private static void printHeaderTask1() {
        System.out.println("------->JAC 444 Workshop 07<-------");
        System.out.println("------->Task 1 ... <-------");
    }

    private static void printHeaderTask4() {
        System.out.println("------->Task 4 ... <-------");
    }
}
