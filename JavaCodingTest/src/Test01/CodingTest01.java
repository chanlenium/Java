package Test01;

public class CodingTest01 {
    public static void main(String[] args) {
        String[] test = {
          "   + -- + - + -   ",
          "   + --- + - +   ",
          "   + -- + - + -   ",
          "   + - + - + - +   "
        };
        solution(test);
    }

    // Change (+) to '1', (-) to '0'
    /** Difference between trim() and strip()
     *  trim() : Removes all leading and trailing character whose ASCII value is less than or equal to 32 ('U+0020' or space)
     *  strip() : Remove all leading and trailing character */
    private static void solution(String[] test) {
        String result = null;
        for(int i = 0; i < test.length; i++){
            // Remove white space and change character(+),(-) to "1","0", respectively
            String tempStr = test[i].strip().replace("+", "1").replace("-","0").replace(" ", "");
            // Change binary number to decimal
            int decimal=Integer.parseInt(tempStr,2);
            // Change ASCII value to character
            char character = (char)decimal;
            // Concatenate characters
            result = (result == null) ? String.valueOf(character) : (result+character);
        }
        System.out.println(result);
    }
}
