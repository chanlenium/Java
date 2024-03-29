public class LabeledContinue {
    public static void main(String[] args){
        final int LIMIT = 6; // constant
        int factory = 1;

        // Label : "outerLoop"
        outerLoop: for(int i = 0; i < LIMIT; i++){
            for(int k = 2; k < i; k++){
                if(i % 2 == 0)
                    continue outerLoop;
                factory *= i;
            }
        }
        System.out.println(factory);
    }
}
