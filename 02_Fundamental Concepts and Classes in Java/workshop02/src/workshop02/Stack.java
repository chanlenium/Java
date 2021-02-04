package workshop02;

public class Stack {
    private final char[] stackArr;  // Since stackArr is not modified, it is declared as 'final'
    private int topPointer;   // variable to indicate top index of stack array
    private final int stackSize;    // variable for stack size

    public Stack(int size) {    // Constructor with 1-argument (stack size)
        topPointer = -1;
        stackSize = size;
        stackArr = new char[stackSize];
    }

    public char pop(){
        char popElement;    // variable to store top element
        if(isEmpty()) {
            System.out.println("Pop fail! Stack is empty!");
            return 0;
        } else {
            popElement = stackArr[topPointer];
            stackArr[topPointer--] = '\0';    // After popping the top element, eliminate it
            // System.out.println("Pop element : " + popElement);
            return popElement;  // return the top element
        }
    }

    public void push(char inputChar){
        if(!isFull())
            stackArr[++topPointer] = inputChar;   // push the element to the top of stack
        else
            System.out.println("Stack is full!");
    }

    public boolean isFull(){
        return (topPointer == stackSize-1);
    }

    public boolean isEmpty() {
        return (topPointer == -1);
    }
}
