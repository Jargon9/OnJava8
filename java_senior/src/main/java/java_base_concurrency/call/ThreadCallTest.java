package java_base_concurrency.call;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCallTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCall test = new ThreadCall();
        FutureTask<String> ft = new FutureTask<>(test);
        new Thread(ft).start();
        System.out.println("线程开始");
        /**
         * 这里才会正则执行
         */
        System.out.println(ft.get());

    }
}
