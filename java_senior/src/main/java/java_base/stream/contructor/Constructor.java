package java_base.stream.contructor;

import java_base.stream.Bubble;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constructor {
    // stream of 会产生一个流对象
    public static void streamOfExm() {
        Stream.of(new Bubble(1), new Bubble(2), new Bubble(3))
                .forEach(System.out::println);
        Stream.of("It's ", "a ", "wonderful ", "day ", "for ", "pie!")
                .forEach(System.out::print);
        System.out.println();
        Stream.of(3.14159, 2.718, 1.618)
                .forEach(System.out::println);
    }


    public static void streamExp() {
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));

        // map对象会获取流中的所有元素，并且对流中元素应用操作从而产生新的元素，并将其传递到后续的流中。通常 map() 会获取对象
        // 并产生新的对象，但在这里产生了特殊的用于数值类型的流。例如，mapToInt() 方法将一个对象流（object stream）转换成为包
        // 含整型数字的 IntStream。同样，针对 Float 和 Double 也有类似名字的操作。
        System.out.println(bubbles.stream()
                .mapToInt(b -> b.i)
                .sum());

        System.out.println(bubbles.stream()
        .mapToDouble(b -> b.i)
        .sum());

        Set<String> w = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        w.stream()
                .map(x -> x + " ")
                .forEach(System.out::print);
        System.out.println();


        // 为了从 Map 集合中产生流数据，我们首先调用 entrySet() 产生一个对象流，每个对象都包含一个 key 键以及与其相关联
        // 的 value 值。然后分别调用 getKey() 和 getValue() 获取值。

        // 这里说明图对象并不能直接转化为流对象，只有集合才可以
        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }

    // 流对象传入范例
    public static <T> void show(Stream<T> stream) {
        stream.limit(4)
                .forEach(System.out::println);
    }

    // boxed() 转化为装箱类型
    public static void streamObjectExp() {
        Random rand = new Random(47);
        show(rand.ints().boxed());
        show(rand.longs().boxed());
        show(rand.doubles().boxed());
        // 控制上限和下限：
        show(rand.ints(10, 20).boxed());
        show(rand.longs(50, 100).boxed());
        show(rand.doubles(20, 30).boxed());
        // 控制流大小：
        show(rand.ints(2).boxed());
        show(rand.longs(2).boxed());
        show(rand.doubles(2).boxed());
        // 控制流的大小和界限
        show(rand.ints(3, 3, 9).boxed());
        show(rand.longs(3, 12, 22).boxed());
        show(rand.doubles(3, 11.5, 12.3).boxed());
    }

    public static void boxedExp() {
        Random rand = new Random(47);
        List<Double> collect = rand.doubles(3, 3, 9).boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        streamObjectExp();
    }
}
