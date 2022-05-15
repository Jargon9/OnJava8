package java_base.stream.function;

import java.util.stream.Stream;

public class SortedExp {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(3,1,10,16,8,4,9);
        stream.sorted().forEach(System.out::println);


    }
}
