package chapter2.chapter2_4;

/**
 * 栈内存溢出
 * jvm args(-Xss128k)
 */
public class JavaVMStackSOF {
    
//    private int stackLength = 1;
    
    public void stackLeak1(int index) {
        System.out.println(index);
        int a = ++index;
        stackLeak2(a);
    }
    public void stackLeak2(int index) {
        System.out.println(index);
        int a = ++index;
        stackLeak3(a);
    }
    public void stackLeak3(int index) {
        System.out.println(index);
        int a = ++index;
        stackLeak1(a);
    }
    
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak1(1);
        } catch (Throwable e) {
//            System.out.println("stack lenght: " + oom.stackLength);
            throw e;
        }
    }

}
