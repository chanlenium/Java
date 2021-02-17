package inheritance01;

public class Main {
    public static void main(String[] args) {
        // case1
        Base b1 = new Base();
        System.out.println(b1.getI());

        // case2
        Extended e1 = new Extended();
        System.out.println(e1.getI());  // Inheritance in here!!
        System.out.println(e1.getJ());

        // case3
        Base b2 = new Extended();   // Inheritance relationship (Reverse relationship is not OK)
        // b2 refers the Extended object at the runtime
        System.out.println(b2.getI());
        // System.out.println(b2.getJ());
        // Not allowed!! -> compile단계에서 b2는 Base class의 object이므로, Extended class의 method에 접근할 수 없음

        // case4
        // Extended e2 = new Base(); // Not allowed!

        // Extended e3 = (Extended) b1; // Explicitly downcast
        // Creates ClassCastException : b1이 Base class type의 object이므로 downcast할 수 없음

        Extended e4 = (Extended) b2; // This time OK!
        // b2는 Base class type으로 선언되었으나, run time에서 실제(actually)는 Extended Class의 obejct를 refer함
        // 그러므로 downcast가능
        System.out.println(e4.getI());
        System.out.println(e4.getJ());

        // but you could make it even safer:
        if(b2 instanceof Extended){ // b2는 run time에서 actually Extended Class의 object를 refer함
            Extended e5 = (Extended) b2;
            System.out.println(e5.getI());
            System.out.println(e5.getJ());
        }
    }
}
