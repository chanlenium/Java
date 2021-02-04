import java.util.Scanner;

public class CommandLineArgs {
    // ALT+SHIFT+F10 > Right > E(Edit) > Enter > Tab > enter your command line parameters > Enter :-))
    public static void main(String[] args) {
        for(String s : args)
            System.out.print(s + " ");

        // Input values into the program
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
        scanner.close();
    }
}