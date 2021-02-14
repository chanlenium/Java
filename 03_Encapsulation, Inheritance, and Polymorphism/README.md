# Workshop 03 & 04 : Encapsulation and Abstraction, Inheritance, Polymorphism, and Exceptions.

## Objective
* Familiar with implementing Inheritance, Polymorphism, Abstraction(Interface)
* Read text file using `BufferedReader`
* Implement custome `Exception`
* Creating and treating *2-D array*
* Cutomize display *number formmating*

## Outline
* When the user enters input value, the program validates input as follows.
```
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
```
* When the user input is validated, the program create stack object and initialize it with 1 argument which is the length of user input
* The program pushes user input to a stack array as follows.
```
for(int i = 0 ; i < palindrome.getUserInput().length(); i++)
    stack.push(palindrome.getUserInput().charAt(i));
```
* The program checks the user input String(Word) is palindrome or not
```
do{
    for(iter = 0 ; iter < palindrome.getUserInput().length(); iter++){
        if(palindrome.getUserInput().charAt(iter) != stack.pop())
            isPalindrome = false;
    }
}while (isPalindrome && iter < palindrome.getUserInput().length());
```
* Print the proper message based on if the input is palindrome or not

## Screenshot
<img src="https://github.com/chanlenium/Java/blob/main/02_Fundamental%20Concepts%20and%20Classes%20in%20Java/screenshot.png" width="600" height="400" />
