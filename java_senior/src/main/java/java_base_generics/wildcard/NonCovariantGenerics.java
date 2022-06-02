package java_base_generics.wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonCovariantGenerics {
    /**
     *
     * List<Fruit> flist = new ArrayList<Apple>();
     * 这种方式是不行的
     */

    public static void main(String[] args) {

        List<? extends Fruit> flist = new ArrayList<>();
//        flist.add(new Apple());
        // Compile Error: can't add any type of object:
//         flist.add(new Apple());
//         flist.add(new Fruit());
//         flist.add(new Object());
        flist.add(null);
        /**
         * flist 的类型现在是 List<? extends Fruit>，你可以读作“一个具有任何从 Fruit 继承的类型的列表”。然而，这实际上
         * 并不意味着这个 List 将持有任何类型的 Fruit。通配符引用的是明确的类型，因此它意味着“某种 flist
         * 引用没有指定的具体类型”。因此这个被赋值的 List 必须持有诸如 Fruit 或 Apple 这样的指定类型，
         * 但是为了向上转型为 Fruit，这个类型是什么没人在意。
         */

        List<Apple> apples = Arrays.asList(new Apple());
        List<? extends Fruit> flist1 = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); // No warning
        flist1.contains(new Apple()); // Argument is 'Object'
        flist1.indexOf(new Apple()); // Argument is 'Object'
    }

}
