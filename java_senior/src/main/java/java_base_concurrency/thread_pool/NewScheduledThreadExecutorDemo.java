
package java_base_concurrency.thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建大小无限的线程池，主要用于延迟执行的任务。
 * DelayedWorkQueue 是无界限的 所以 maximumsizes是无意义的
 */
public class NewScheduledThreadExecutorDemo {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(16);

        for (int i = 0; i < 100; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start:" + no);
                        Thread.sleep(1000L);
                        System.out.println("end:" + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            // 10s后执行
            executorService.schedule(runnable, 10, TimeUnit.SECONDS);
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");


    }

}
