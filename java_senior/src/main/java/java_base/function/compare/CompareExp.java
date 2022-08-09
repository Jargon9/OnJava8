package java_base.function.compare;

public class CompareExp {
    static class Soft implements Strategy {
        public String approach(String msg) {
            return msg.toLowerCase() + "?";
        }

    }

    static class Unrelated {
        static String twice(String msg) {
            return msg + " " + msg;
        }
    }

    public static class Strategize{
        Strategy strategy;
        String msg;
        Strategize(String msg) {
            strategy = new Soft();
            this.msg = msg;
        }

        void communicate() {
//            System.out.println(strategy.approach(msg));
            System.out.println(strategy.approach(msg));
        }

        void changeStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public static void main(String[] args) {
            // lambda 只能代表一个函数。如果是双函数就会报错
            Strategy[] strategies = {
                    /**
                     * 一种略显简短且更自发的方法是创建一个匿名内部类。
                    */
                    new Strategy() {
                        @Override
                        public String approach(String msg) {
                            return msg.toUpperCase() + "1";
                        }
                    },
                    /**
                     * Java 8 的 Lambda 表达式。由箭头 -> 分隔开参数和函数体，箭头左边是参数，箭头右侧是从 Lambda 返回的表达
                     * 式，即函数体。这实现了与定义类、匿名内部类相同的效果，但代码少得多。
                    */
                    msg -> msg.substring(0, 5),
                    /**
                     * Java 8 的方法引用，由 :: 区分。在 :: 的左边是类或对象的名称，在 :: 的右边是方法的名称，但没有参数列表。
                    */
                    Unrelated::twice
            };
            // JAVA 8之前只允许上述的第一个过程

            Strategize s = new Strategize("hello world");
            s.communicate();

            for(Strategy newStrategy : strategies) {
                s.changeStrategy(newStrategy);
                s.communicate();
            }
        }
    }
}
