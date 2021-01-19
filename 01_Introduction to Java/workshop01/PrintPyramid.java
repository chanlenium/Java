// Name: DONG CHAN OH
// Seneca Student ID: 128975190
// Seneca email: dcoh@myseneca.ca

public class PrintPyramid {
    final static int numOfRow = 8; // number of Rows which is constant value
    public static void main(String[] args) {
        // Nested for Loop with parameter (i, j)
        for(int i = 0; i < numOfRow; i++){  // row index i
            // Print indentation
            for(int j = 0; j < numOfRow - i; j++)
                System.out.print("\t"); // In Java, Tab is composed of 4 spaces

            // Print Number : 2^(i-|i-j|)
            // Cast value to (int) to match the format "%d"
            for(int j = 0; j < (2*i)+1; j++)
                System.out.format("%4d", (int)Math.pow(2,(i-Math.abs(i-j))));

            System.out.println();   // Print newline
        }
    }
}

// Num of Class : PrintPyramid, String, [], System
// object : out
// method : main, print, format, println

