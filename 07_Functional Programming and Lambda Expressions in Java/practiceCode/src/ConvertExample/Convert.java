package ConvertExample;
@FunctionalInterface
public interface Convert<U, V> {
    V change(U u, V v);
}
