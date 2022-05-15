package java_base.stream.contructor;

import jdk.nashorn.internal.ir.CallNode;

import java.util.stream.Stream;

public class OtherWays {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5).parallel();
        integerStream.forEach(System.out::println);
        System.out.println("--------------------");
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2).limit(10);
        iterate.forEach(System.out::println);
        System.out.println("--------------------");
        Stream<Double> limit = Stream.generate(Math::random).limit(10);
        limit.forEach(System.out::println);


    }
}
