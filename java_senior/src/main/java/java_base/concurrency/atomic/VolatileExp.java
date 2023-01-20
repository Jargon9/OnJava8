package java_base.concurrency.atomic;

public class VolatileExp {
    private volatile int num = 0;

    public void increase() {
        num++;

    }

    public int get() {
        return num;
    }
}
