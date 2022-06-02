package java_base_generics.base_exp;

public class TestMain {
    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        h3.set(new Automobile());
        Automobile automobile = h3.get();

        /**
         * 这里需要转型就比较不方便
         */
        ObjectTest h2 = new ObjectTest(new Automobile());
        Automobile o = (Automobile)h2.get();
    }
}
