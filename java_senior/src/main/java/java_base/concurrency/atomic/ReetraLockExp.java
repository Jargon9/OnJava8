package java_base.concurrency.atomic;

import java.util.concurrent.locks.ReentrantLock;

public class ReetraLockExp {
    ReentrantLock Lock = new ReentrantLock();

    private int num = 0;

    public void increase() {
        Lock.lock();
        num++;
        Lock.unlock();
    }

    public int get() {
        return num;
    }
}
