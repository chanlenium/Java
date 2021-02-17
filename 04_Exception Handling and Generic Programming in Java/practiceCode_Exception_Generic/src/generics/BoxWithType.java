package generics;
/** Generic Box class **/
public class BoxWithType<T> {
    private T t;

    public void add(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }
}
