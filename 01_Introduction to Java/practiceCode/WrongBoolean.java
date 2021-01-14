public class WrongBoolean {
    public static void main(String[] args) {
        byte x = 1;
        boolean y = false;
        System.out.println(x & y);  // error
        // a Java programming language boolean type can't be converted to any numeric type
    }
}
