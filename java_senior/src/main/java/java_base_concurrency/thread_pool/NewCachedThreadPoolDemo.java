
package java_base_concurrency.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存的线程池，如果线程池的大小超过了处理任务所需要的线程
 * 那么会回收部分空闲的线程（60秒不执行新任务）
 * 此线程池不会限制大小，直到系统挂掉
 */
public class NewCachedThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10000; i++) {
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
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");


    }

}
