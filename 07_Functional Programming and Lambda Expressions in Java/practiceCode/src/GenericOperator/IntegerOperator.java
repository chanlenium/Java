package GenericOperator;

public class IntegerOperator {
    public static void main(String[] args) {
        // lambda expression
        // sum : function pointer, numbers : parameters passed to the function
        GenericOperator<Integer> sum = numbers -> {
            Integer total = 0;
            for(Integer x : numbers)
                total = total + x;
            return total;
        };
        System.out.println("Additional result: " + sum.operator(1, 2, 3, 4, 5));
    }
}
