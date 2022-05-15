package java_base.stream.contructor;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysCreateExp {
    public static void main(String[] args) {
        String[] strs = {"s", "y"};
        Stream<String> stream = Arrays.stream(strs);
    }
}
