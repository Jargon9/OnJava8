package java_base.concurrency.wait;

public class WaitExp {

    public static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA(o);
        threadA.start();
        Thread.sleep(200L);
        synchronized(o){
            o.notify();
        }
    }
}
