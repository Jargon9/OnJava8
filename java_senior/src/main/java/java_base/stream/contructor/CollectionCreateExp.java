package java_base.stream.contructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionCreateExp {
    public static void collectionExp() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        // 并行流
        Stream<String> stringStream = list.parallelStream();
    }


}
