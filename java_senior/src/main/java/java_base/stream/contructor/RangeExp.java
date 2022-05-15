package java_base.stream.contructor;

import java.util.Random;
import static java.util.stream.IntStream.*;

public class RangeExp {
    public static void main(String[] args) {
        range(10, 20)
                .sum();
    }
}
