public class InnerClass {
    public int i = 10;

    public class Inner{
        public int i = 20;
    }

    public static void main(String[] args) {
        InnerClass.Inner ref = new InnerClass().new Inner();
        System.out.println(ref.i);
    }
}
