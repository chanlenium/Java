import javax.swing.*;

public class Addition {
    public static void main(String[] args) {
        // obtain user Input from JOptionPane input dialogs
        String firstNumber = JOptionPane.showInputDialog("Enter first integer");
        String secondeNumber = JOptionPane.showInputDialog("Enter second Integer");

        // covert String inputs to int values for use in a calculation
        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondeNumber);

        int sum = number1 + number2;

        // display result in JOptionPane message dialog
        JOptionPane.showMessageDialog(null,
                "The sum is " + sum,
                "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
        // JOptionPane.ERROR_MESSAGE (or PLAIN_MESSAGE)
    }
}
