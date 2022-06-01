package java_base_function.recursion;

public class FibonacciExp {
    interface Func {
        int cul(int n);
    }

    static Func x;

    public static void main(String[] args) {
        x = n -> n > 0 ? x.cul(n-2) + x.cul(n-1):2;
        for (int i=0; i<10; i++) {
            System.out.println(x.cul(i));
        }
    }
}
