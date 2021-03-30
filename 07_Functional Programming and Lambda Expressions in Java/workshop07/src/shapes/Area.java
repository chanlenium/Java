package shapes;
@FunctionalInterface
public interface Area<T, V> {
    //double getArea(double x, double y); // abstract method
    T getArea(T x, V y);
}
