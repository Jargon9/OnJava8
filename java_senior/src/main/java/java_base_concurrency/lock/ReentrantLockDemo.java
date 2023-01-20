
package java_base_concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) {
        final java_base_concurrency.lock.ReentrantLockNum count = new java_base_concurrency.lock.ReentrantLockNum();

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}
