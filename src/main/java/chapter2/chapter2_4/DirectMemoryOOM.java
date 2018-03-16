package chapter2.chapter2_4;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * jvm args(-XX:PermSize=10M -XX:MaxPermSize=10M)
 * @author Mengx
 *
 */
public class DirectMemoryOOM {
    
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while(true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
