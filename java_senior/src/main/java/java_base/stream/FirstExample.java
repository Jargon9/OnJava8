package java_base.stream;

import java.util.Random;

public class FirstExample {
    public static void random() {
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
        // 上述问题中的 :: 代表：
        // lambda 表达式
    }


    public static void main(String[] args) {
        random();
    }
}
