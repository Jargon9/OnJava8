package java_base.stream.contructor;

import java.util.Random;

public class RandomExp {
    public static void main(String[] args) {
        new Random(13)
                .ints()
                .limit(10)
                .sorted()
                .forEach(System.out::println);
    }
}
