package java_base_concurrency.thread_pool;

import java_base_concurrency.call.ThreadCall;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 这里值得注意的是 提交的任务设置了超时时间
 */
public class FutureTaskCase {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Callable<String> task = new ThreadCall();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit1 = executorService.submit(task);
        Future<String> submit2 = executorService.submit(task);
        String s = submit1.get(1, TimeUnit.MINUTES);
        String s1 = submit2.get(1, TimeUnit.MINUTES);
        System.out.println(s + s1);
    }
}
