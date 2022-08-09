package java_base.concurrency.wait;

public class ThreadA extends Thread {

    public Object o;

    ThreadA(Object a) {
        this.o = a;
    }

    @Override
    public void run() {
        synchronized(o) {
            try {
                long l = System.currentTimeMillis();
                System.out.println("开始等待");
                o.wait(1000L);
                System.out.println("实际等待" + (System.currentTimeMillis() - l));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
