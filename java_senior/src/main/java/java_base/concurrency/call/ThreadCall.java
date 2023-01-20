package java_base.concurrency.call;

import java.util.concurrent.Callable;

public class ThreadCall implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("开始call");
        return "ThreadCall return";
    }
}
