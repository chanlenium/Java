import java.util.Scanner;

public class Utils {
    Scanner keyboard;

    public int enterInteger(int min, int max) {
        int returnVal = 0;
        boolean keepTypingInput = true;   // variable to indicate user needs to type input again

        keyboard = new Scanner(System.in);
        keyboard.useDelimiter("\n");  // Set input delimiter as "new line(\n)"
        do {
            // If user's input does not meet regex pattern, user is asked to type input again
            // until the user's input satisfies regex pattern.
            if (!keyboard.hasNextInt() || keyboard.hasNext("[ ]*")) {
                System.out.print("Invalid input!! Please enter a valid value again : ");
                keyboard.next(); // Finds and returns the next complete token from this scanner.
            } else {
                returnVal = keyboard.nextInt();
                if (returnVal <= min || returnVal > max) {
                    System.out.print("Out of range!! Please enter a valid value again : ");
                } else {
                    keepTypingInput = false;
                }
            }
        } while (keepTypingInput);
        return returnVal;
    }

    public String enterString(String pattern) {
        String returnVal = null;
        boolean keepTypingInput = true;   // variable to indicate user needs to type input again

        keyboard = new Scanner(System.in);
        keyboard.useDelimiter("\n");  // Set input delimiter as "new line(\n)"

        do {
            // If user's input does not meet regex pattern, user is asked to type input again
            // until the user's input satisfies regex pattern.
            if (!keyboard.hasNext(pattern)) {
                System.out.print("Invalid input!! Please enter a valid value : ");
                keyboard.nextLine(); // Finds and returns the next complete token from this scanner.
            }else{
                // When user's input meets regex pattern, variable "userInput" is set to user's input
                keepTypingInput = false;
                returnVal = keyboard.nextLine();
            }
        } while (keepTypingInput);
        return returnVal;
    }
}