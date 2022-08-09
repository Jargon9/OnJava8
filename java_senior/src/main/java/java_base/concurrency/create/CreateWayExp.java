package java_base.concurrency.create;

public class CreateWayExp {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("start" + Thread.currentThread().getName());
            }
        };
        Thread test = new Thread(task);
        test.setName("test");
        // run 用于主线程，打出来的名称是main,和多线程没有关系。
        test.run();

        // start打出来是 test
    }


}
