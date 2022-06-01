package java_base_function.compare;

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
                    new Strategy() {
                        @Override
                        public String approach(String msg) {
                            return msg.toUpperCase() + "1";
                        }
                    },
                    msg -> msg.substring(0, 5),
                    Unrelated::twice
            };

            Strategize s = new Strategize("hello world");
            s.communicate();

            for(Strategy newStrategy : strategies) {
                s.changeStrategy(newStrategy);
                s.communicate();
            }
        }
    }
}
