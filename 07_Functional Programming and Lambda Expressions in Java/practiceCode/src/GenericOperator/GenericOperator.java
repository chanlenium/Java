package GenericOperator;

public interface GenericOperator<T> {
    T operator(T... operands);
}
