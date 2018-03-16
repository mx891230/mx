package chapter2.chapter2_4;

/**
 * 堆内存溢出
 * jvm args(-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError)
 */
public class HeapOOM {
    
    static class OOMObject {
        
    }

    public static void main(String[] args) {
//        while(true) {
//            list.add(new OOMObject());
//        }
        
        // max size 1024 * 791
        int size = 1024 * 1024 * 3;
        String[] str = new String[size];
        test();
        System.out.println(str.length);
        System.out.println("finish");
    }
    
    public static void test() {
        int size = 1024 * 1024 * 1;
        String[] str = new String[size];
        System.out.println(str.length);
    }

}
