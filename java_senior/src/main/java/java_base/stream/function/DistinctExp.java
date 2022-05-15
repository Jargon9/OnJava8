package java_base.stream.function;

import java.util.stream.Stream;

public class DistinctExp {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "3","4","10","4","6","23","3");
        stream.distinct().forEach(System.out::println);
    }
}
