package java_base.concurrency.thread_pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Discartcase {
    public static void main(String[] args) {
        ExecutorService handleThreadPool;
        BlockingQueue<Runnable> scanInstanceQueue = new LinkedBlockingQueue<>(10000);
        System.out.println(ObjectSizeCalculator.getObjectSize(scanInstanceQueue));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(1);
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        scanInstanceQueue.add(runnable);
        System.out.println(ObjectSizeCalculator.getObjectSize(scanInstanceQueue));
        System.out.println(ObjectSizeCalculator.getObjectSize(1));
//        handleThreadPool = new ThreadPoolExecutor(
//                1, 1,
//                0, TimeUnit.NANOSECONDS,
//                scanInstanceQueue,
//                new ThreadFactoryBuilder()
//                        .setNameFormat("handleAutoCreateMsgThreadPool")
//                        .setUncaughtExceptionHandler((t, e) ->
//                                System.out.println(("UncaughtExceptionHandler threadName:{}"))).build(),
//                new ThreadPoolExecutor.AbortPolicy());
//        handleThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(1);
//                    Thread.sleep(5000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        handleThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(2);
//                    Thread.sleep(5000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        handleThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(3);
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        handleThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(4);
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        handleThreadPool.shutdown();
    }
}

