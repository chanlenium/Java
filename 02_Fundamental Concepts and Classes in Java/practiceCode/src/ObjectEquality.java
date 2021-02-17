public class ObjectEquality {
    public static void main(String[] args) {
        // Both x and y have equal contents "1", but x, y are reference value (not actual value)
        // x and y have different address in which just content values are equal (i.e., "1")
        String x = "1"; // Literal "1" which address is dedicated
        String y = new String("1"); // String object with value "1" which address is dynamically allocated
        System.out.println(x==y ? "Equal" : "Not Equal");

        // Using method "equals()" => contents를 비교하는 매서드
        System.out.println(x.equals(y) ? "Equal" : "Not Equal");
    }
}
