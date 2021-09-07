package Test04;

public class Test04 {
    public static void main(String[] args) {
        int[][] firstField = {
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };
        int[][] secondField = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 3},
                {0, 0, 0, 0, 4},
                {0, 2, 0, 0, 2},
                {4, 5, 0, 2, 0}
        };
        solution(firstField, secondField);
    }

    private static void solution(int[][] firstField, int[][] secondField) {
        int len = secondField.length;
        int[][] resultField = new int[len][len];

        // Rotate the secondField to the left by -90 degrees
        // and add the firstField
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                resultField[i][j] = secondField[j][len-1-i];
                resultField[i][j] += firstField[i][j];
            }
        }

        // Covert Octec to Character
        for(int i = 0; i < len; i++){
            String str = "";
            for(int j = 0; j < len; j++){
                str += resultField[i][j];
            }
            System.out.println((char)Integer.parseInt(str, 8));
        }
    }
}
