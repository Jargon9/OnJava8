package java_senior.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class unsafeCreateExp {

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Unsafe unsafe = reflectGetUnsafe();
    }

}
