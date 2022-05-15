package java_base.stream.function;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekExp {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello", "felord.cn");
        stream.peek(System.out::println);
        // 上面的代码并不会打印，因为流是懒加载的。


        // 只有最后到结束才会打印
        Stream<String> stream1 = Stream.of("hello", "felord.cn");
        stream1.peek(System.out::println).collect(Collectors.toList());
    }
}
