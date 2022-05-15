package java_base.stream.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapExp {
    public static void main(String[] args) {
        // 将内部的集合 变成流后拼接起来
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2).limit(5);
        List<Integer> collect = iterate.flatMap(s -> {
            Integer[] s1 = new Integer[1];
            s1[0] = s;
            Stream<Integer> stream = Arrays.stream(s1);
            return stream;
        }).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);


        List<String> list1 = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list1.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("处理前的集合：" + list1);
        System.out.println("处理后的集合：" + listNew);
    }

}
