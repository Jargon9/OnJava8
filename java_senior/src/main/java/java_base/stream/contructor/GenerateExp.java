package java_base.stream.contructor;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateExp implements Supplier<String>  {
    Random rand = new Random(47);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String get() {
        // rand10  0 - 9
        return "" + letters[rand.nextInt(letters.length)];
    }

    // 随机生成大写字母
    // generate 调用
    // - 传入对象 调用get方法
    // - 传入方法 直接调用方法
    public static void main(String[] args) {
        // generate调用 Supplier 的 get。
        String word = Stream.generate(new GenerateExp())
                .limit(30) // 调用30次get。
                .collect(Collectors.joining());
        System.out.println(word);

        // 直接使用 lamada
        Stream.generate(() -> 1)
                .limit(2)
                .mapToInt( x -> x ) // 转换为 intStream
                .sum();

    }

}
