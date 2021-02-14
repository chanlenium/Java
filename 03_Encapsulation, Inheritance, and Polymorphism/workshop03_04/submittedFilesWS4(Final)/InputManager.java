package shapes;

import java.util.Arrays;

public class InputManager {
    // When the input meets exception conditions, it throw customize exception
    public static boolean validate(String[] tokens, boolean isValid) throws WrongValueException {
        // First, check the 1st element of tokens is one of Shapes
        if(tokens[0].matches("Circle|Square|Rectangle|Parallelogram|Triangle")){
            int start = 1, end = tokens.length - 1; // initiate start and end value
            // slice the tokens from the second element to the last element (extract values except Shape's name)
            double[] slice = Arrays.stream(Utils.getSliceOfArray(tokens, start, end + 1))
                    .mapToDouble(Double::parseDouble)
                    .toArray(); // Conversion string array to double array

            switch (tokens[0]){
                case "Circle":
                case "Square":
                    if(tokens.length == 2){ // check the number of values for the shapes "Circle" and "Square"
                        if(Utils.isAllPositive(slice))    // check all radius or sides are positive
                            isValid = true;
                        else    // If the token has wrong values(e.g., 0 or negative values), throw exception
                            if(tokens[0].equals("Circle"))
                                throw new WrongValueException("Invalid radius!");
                            else
                                throw new WrongValueException("Invalid side!");
                    }
                    break;
                case "Rectangle":
                case "Parallelogram":
                    if(tokens.length == 3){
                        if(Utils.isAllPositive(slice))
                            isValid = true;
                        else
                            throw new WrongValueException("Invalid side(s)!");
                    }
                    break;
                case "Triangle":
                    if(tokens.length == 4){
                        // 1. check all sides' values are positive
                        // 2. maximum length side is shorter than the sum of other sides' lengths
                        double maxValueInSlice = Arrays.stream(slice).max().orElse(13421);  // get value using orElse
                        if(Utils.isAllPositive(slice) && (Arrays.stream(slice).sum() - maxValueInSlice > maxValueInSlice))
                            isValid = true;
                        else
                            throw new WrongValueException("Invalid side(s)!");
                    }
            }
        }
        return isValid;
    }
}
