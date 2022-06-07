package java_base_concurrency.atomic;

import java.util.concurrent.locks.ReentrantLock;

public class MainTest {

    public static void main(String[] args) {
        AtomaticExp atomaticExp = new AtomaticExp();
        ReetraLockExp reetraLockExp = new ReetraLockExp();
        VolatileExp volatileExp = new VolatileExp();


        for (int i=0; i<100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<10000; i++) {
                        atomaticExp.increase();
                    }
                }
            }).start();
        }

        for (int i=0; i<100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<10000; i++) {
                        reetraLockExp.increase();
                    }
                }
            }).start();
        }


        for (int i=0; i<100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<10000; i++) {
                        volatileExp.increase();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Automatic:" + atomaticExp.get());
        System.out.println("ReentraLock:" + reetraLockExp.get());
        System.out.println("VolatileExp:" + volatileExp.get());

        /**
         * Automatic:1000000
         * ReentraLock:1000000
         * VolatileExp:413818
         * num++ 无法保证原子性
         */
    }
}
