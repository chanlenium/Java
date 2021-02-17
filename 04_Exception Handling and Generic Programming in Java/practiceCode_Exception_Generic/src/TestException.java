public class TestException {
    public static void test(int k, int[] intArray, String string){
        int j = 1/k;
        int len = intArray.length + 1;
        char c;

        try{
            c = string.charAt(0);
            if(k == 10)
                j = intArray[3];
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Array Index Out Of Bounds Exception");
        }catch(ArithmeticException ex){
            System.out.println("Arithmetic Exception");
        }catch(NullPointerException ex){
            System.out.println("NullPointer Exception");
        }finally{
            System.out.println("Finally Clause");
        }
        System.out.println("Exit Try Block");
    }

    public static void main(String[] args) {
        int k = 0;
        int[] ia = {1, 2, 3};
        String s = "jac444";

        // Case 1 : To handle exception, the corresponding code must place in try~catch block
        // Or, crash error is happened.
        //test(k, ia, s);

        // Case 2 :
        // Even the corresponding code places in try~catch block,
        // Crash happens unless a proper(matched) catch block does not exist
        k = 10; s = "";
        // test(k, ia, s);

        // Case 3 :
        // Array Index Out Of Bounds Exception
        // Finally Clause
        // Exit Try Block
        s = "Dongchan";
        test(k, ia, s);

        // Case : 4
        // NullPointer Exception
        // Finally Clause
        // Exit Try Block
        s= null;
        test(k, ia, s);

    }

}
