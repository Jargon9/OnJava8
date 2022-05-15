package java_base.stream.contructor;

import java.util.stream.Stream;

public class ParallelStreamExp {

    public static void main(String[] args) {
        /**
         * 无序的多次输出
         */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5).parallel();
        integerStream.forEach(System.out::println);

        /**
         * 有序的多次输出 1 2 3 4 5
         */
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5);
        integerStream1.forEach(System.out::println);
    }
}
