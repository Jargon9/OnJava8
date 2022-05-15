package java_base.stream.end;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FirstMatchExp {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(3,1,10,16,8,4,9);
        Optional<Integer> first = stream.findFirst();
        System.out.println(first.get());


        // any的速度更快，特别是在并发的时候
        Stream<Integer> stream1 = Stream.of(3,1,10,16,8,4,9);
        Optional<Integer> any = stream1.findAny();
        System.out.println(any.get());


        List<String> strAry = Arrays.asList( "Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");

        String result = strAry.parallelStream().filter(s->s.startsWith("J")).findAny().get();
        System.out.println("result = " + result);

    }
}
