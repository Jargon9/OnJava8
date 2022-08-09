package java_base.concurrency.join;

public class Join {

    /**
     * 这里为何自己的锁，和object的锁是不同的，不是很理解。
     * 网上有解释：https://blog.csdn.net/succing/article/details/123023851?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-123023851-blog-124182397.pc_relevant_aa&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-123023851-blog-124182397.pc_relevant_aa&utm_relevant_index=1
     * @param args
     */
    public static void main(String[] args) {
        Object oo = new Object();

        MyThread thread1 = new MyThread("thread1 -- ");
        //oo = thread1;
        thread1.setOo(oo);
        thread1.start();

        synchronized (thread1) {  // 这里用oo或thread1/this
            for (int i = 0; i < 100; i++) {
                if (i == 20) {
                    try {
//                        oo.wait(0);
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }
    }
}

class MyThread extends Thread {

    private String name;
    private Object oo;

    public void setOo(Object oo) {
        this.oo = oo;
    }

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this) { // 这里用oo或this，效果不同
            for (int i = 0; i < 100; i++) {
                System.out.println(name + i);
            }
        }
    }

}
