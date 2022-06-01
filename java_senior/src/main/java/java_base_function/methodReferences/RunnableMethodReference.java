package java_base_function.methodReferences;

public class RunnableMethodReference {
    public static void main(String[] args) {

        /**
         * 匿名内部类的写法
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();
    }
}
