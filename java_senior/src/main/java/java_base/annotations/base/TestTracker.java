package java_base.annotations.base;

import java.util.List;
import java.util.stream.*;
import java.lang.reflect.*;

public class TestTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        // getDeclaredMethods 反射方法
        for(Method m : cl.getDeclaredMethods()) {
            /**
             * getAnnotation 反射方法  getAnnotation() 方法返回指定类型的注解对象 如果被注解的方法上没有该类型的注解，
             * 返回值就为 null。
              */
            Test uc = m.getAnnotation(Test.class);
            if(uc != null) {
                System.out.println("Found Use Case " +
                        uc.id() + "\n " + uc.describe());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        useCases.forEach(i ->
                System.out.println("Missing use case " + i));
    }
    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(47, 51)
                .boxed().collect(Collectors.toList());
        trackUseCases(useCases, PasswordUtils.class);
    }


    /**
     * Found Use Case 48
     * no description
     * Found Use Case 47
     * Passwords must contain at least one numeric
     * Found Use Case 49
     * New passwords can't equal previously used ones
     * Missing use case 50
     */
}
