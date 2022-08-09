
package java_base.concurrency.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程先吃，如果线程异常结束，会有新的线程去继续执行，
 * 会执行掉缓存里的所有任务
 */
public class NewSingleThreadExecutorDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int no = i;
            executorService.execute(() -> {
                System.out.println("start:" + no);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end:" + no);
            });
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");
    }

}
