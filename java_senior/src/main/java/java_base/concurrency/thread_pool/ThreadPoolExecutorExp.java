package java_base.concurrency.thread_pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExp {
    public static void main(String[] args) {
        // 获取cpu核数量
        int coreSize = Runtime.getRuntime().availableProcessors();
        int maxSize = coreSize * 2;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(500);

        new ThreadPoolExecutor(coreSize, maxSize, 1, TimeUnit.MINUTES, workQueue);
    }
}
