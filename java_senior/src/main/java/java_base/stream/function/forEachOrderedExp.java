package java_base.stream.function;

import java.util.stream.Stream;

public class forEachOrderedExp {
    public static void main(String[] args) {
        Stream.of("AAA,","BBB,","CCC,","DDD,").parallel().forEach(System.out::print);
        System.out.println("\n______________________________________________");
        Stream.of("AAA,","BBB,","CCC,","DDD").parallel().forEachOrdered(System.out::print);
        System.out.println("\n______________________________________________");
        Stream.of("DDD,","AAA,","BBB,","CCC").parallel().forEachOrdered(System.out::print);
    }
}
