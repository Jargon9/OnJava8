package java_base_concurrency.interrupt;

public class InterruptExp {
    /**
     * interrupt 正常的running会结束，但是出现 sleep wait join 会抛出错误。
     */
    static Object oo = new Object();
    public static void main(String[] args) {
        Thread thread = new Thread(new Thread1());
        thread.start();
        thread.interrupt();
    }
}


class Thread1 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("线程中断");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Thread 1 开始执行");

    }
}
