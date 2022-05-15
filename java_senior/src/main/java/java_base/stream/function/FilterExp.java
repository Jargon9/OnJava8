package java_base.stream.function;

import java.util.stream.Stream;

public class FilterExp {
    public static void main(String[] args) {
        Stream<Integer> limit = Stream.iterate(0, (x) -> x + 2).limit(5);
        limit.filter((x)-> x>5).forEach(System.out::println);
    }
}
