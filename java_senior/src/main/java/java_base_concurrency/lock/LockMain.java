package java_base_concurrency.lock;

public class LockMain {
    public static void main(String[] args) {
        java_base_concurrency.lock.SynchronizedNum synchronizedNum = new java_base_concurrency.lock.SynchronizedNum();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedNum.add();
            }
        }).start();

        /**
         * 这个Thread sleep 后，上下两个不会死锁，否则会死锁。
         */
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedNum.lockMethod();
            }
        }).start();
    }
}
