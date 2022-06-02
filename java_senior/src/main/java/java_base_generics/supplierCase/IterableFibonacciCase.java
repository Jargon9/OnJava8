package java_base_generics.supplierCase;

import java.util.Iterator;

public class IterableFibonacciCase extends FibonacciCase implements Iterable<Integer> {
    private int n;
    private IterableFibonacciCase(int count) {
        this.n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n -- ;
                return IterableFibonacciCase.this.get();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacciCase(10)) {
            System.out.println(i + " ");
        }
    }
}
