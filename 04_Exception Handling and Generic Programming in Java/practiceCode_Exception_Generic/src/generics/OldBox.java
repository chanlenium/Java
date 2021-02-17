package generics;
//the advantage of using "generics" in Java is to have
//stronger type checkings at compile time
public class OldBox {
    public static void withoutGeneric(){
        Box myBox = new Box();
        myBox.add(10);  // note : 10 as an object

        // Downcast to Integer
        Integer val = (Integer) myBox.get();
        System.out.println(val);

        // Now, there would be a problem at run-time
        // Since Integer cannot be cast to String..
        String s = (String) myBox.get();
        System.out.println(s);
    }

    public static void main(String[] args) {
        OldBox.withoutGeneric();
    }
}
