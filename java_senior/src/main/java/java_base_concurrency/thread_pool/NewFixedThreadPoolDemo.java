
package java_base_concurrency.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 与单线程不同的是，这里是多个，线程出错后，会创建新的线程替代
 * 这里的缓存队列也是无穷大的。这里是坑
 */
public class NewFixedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            final int no = i;
            executorService.execute(() -> {
                try {
                    System.out.println("start:" + no);
                    Thread.sleep(1000L);
                    System.out.println("end:" + no);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");
    }

}
