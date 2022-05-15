package java_base.stream.end;

import java.util.stream.Stream;

public class AnyMatchExp {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(3,1,10,16,8,4,9);
        boolean b = stream.anyMatch(x -> x > 10);
        System.out.println(b);

        Stream<Integer> stream1 = Stream.of(3,1,10,16,8,4,9);
        boolean b1 = stream1.allMatch(x -> x < 100);
        System.out.println(b1);

        Stream<Integer> stream2 = Stream.of(3,1,10,16,8,4,9);
        boolean b2 = stream1.noneMatch(x -> x < 100);
        System.out.println(b2);

    }
}
