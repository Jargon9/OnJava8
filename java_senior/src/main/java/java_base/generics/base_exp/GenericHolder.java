package java_base.generics.base_exp;

public class GenericHolder<T> {
    private T a;
    public GenericHolder() {}
    public void set(T a) {
        this.a = a;
    }
    public T get() {
        return a;
    }
}
