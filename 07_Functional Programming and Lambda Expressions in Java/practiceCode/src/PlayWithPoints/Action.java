package PlayWithPoints;

@FunctionalInterface    // explicit declaration
public interface Action <T>{
    void change(T t);   // virtual function
}
