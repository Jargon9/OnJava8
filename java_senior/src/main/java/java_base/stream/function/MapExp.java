package java_base.stream.function;

import java.util.function.Function;
import java.util.stream.Stream;

public class MapExp {

    public static void main(String[] args) {
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2).limit(5);
        Stream<Double> doubleStream = iterate.map(new Function<Integer, Double>() {
            @Override
            public Double apply(Integer integer) {
                return Double.valueOf(integer);
            }
        });

        // 只能使用一次，多次使用便会报错。
        iterate.forEach(System.out::println);


        Stream<String> xxx = Stream.of("xxx", "yyy");
        xxx.map(String::toUpperCase).forEach(System.out::println);

        doubleStream.map((Double x) -> x).forEach(System.out::println);
    }

}
