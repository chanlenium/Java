package workshop02;

import java.util.Scanner;

public class Palindrome {
    private String userInput;   // variable to store the input from the command-line

    public String getUserInput() {  // getter (Not use "this" keyword)
        return userInput;
    }

    public void setUserInput(String userInput) {    // setter
        this.userInput = userInput; // use "this" keyword
    }

    // Class method to receive a user command input
    // In this code, I set the one alphabetic word is only validated
    // If you want to number and space additionally, change regex pattern as "[A-Za-z0-9 ]*"
    public void enterWord(){
        Scanner sc = new Scanner(System.in);    // Create Scanner object
        sc.useDelimiter("\n");  // Set input delimiter as "new line(\n)"

        boolean keepTypingInput = true;   // variable to indicate user needs to type input again
        do{
            System.out.print("Please enter a word : ");
            // If user's input does not meet regex pattern, user should type input again
            // until the user's input satisfies regex pattern.
            while (!sc.hasNext("[A-Za-z]*")) {
                System.out.print("Please enter a valid value : ");
                sc.next(); // Finds and returns the next complete token from this scanner.
            }
            // When user's input meets regex pattern, variable "userInput" is set to user's input
            keepTypingInput = false;
            setUserInput(sc.next());
        }while(keepTypingInput);
        System.out.println("You entered a word : " + getUserInput()); // Print valid user input
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();   // Create Class object
        palindrome.enterWord(); // call enterWord() to receive user input
        Stack stack = new Stack(palindrome.getUserInput().length()); // Create Class object with user's input word length
        boolean isPalindrome = true;    // variable to indicate user's input is palindrome or not
        int iter = 0;   // index to iterate String(Word) in character-by-character manner

        // Push user input to a stack array
        for(int i = 0 ; i < palindrome.getUserInput().length(); i++)
            stack.push(palindrome.getUserInput().charAt(i));

        // Check the user input String(Word) is palindrome or not
        do{
            for(iter = 0 ; iter < palindrome.getUserInput().length(); iter++){
                if(palindrome.getUserInput().charAt(iter) != stack.pop())
                    isPalindrome = false;
            }
        }while (isPalindrome && iter < palindrome.getUserInput().length());

        if(isPalindrome)
            System.out.println("User input word " + palindrome.getUserInput() + " is Palindrome");
        else
            System.out.println("User input word " + palindrome.getUserInput() + " is Not Palindrome");
    }
}
