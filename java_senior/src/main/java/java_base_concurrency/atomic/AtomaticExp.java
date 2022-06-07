package java_base_concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AtomaticExp {
    AtomicInteger num = new AtomicInteger();


    public void increase() {
        num.incrementAndGet();
    }

    public int get() {
        return num.get();
    }
}
