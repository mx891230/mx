package chapter3.chapter3_2;

import java.util.concurrent.TimeUnit;
/**
 * jvm args(-XX:+PrintGCDetails -XX:+PrintGCDateStamps)输出GC的详细日志 + 时间
 * @author Mengx
 *
 */
public class FinalizeEscapeGC {
    
    public static FinalizeEscapeGC SAVE_HOOK = null;
    
    public void isAlive() {
        System.out.println("==========yes, i am still alive;");
    }
    
    @Override
    protected void finalize()
        throws Throwable {
        super.finalize();
        System.out.println("==========finalize method executed!");
        SAVE_HOOK = this;
    }



    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGC();
        
        //第一次成功拯救自己，躲过GC的回收
        SAVE_HOOK = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("==========no, i am dead;");
        }
        
        //第二次拯救自己失败，因为任何一个对象的finalize()方法只会被系统自动调用一次
        SAVE_HOOK = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("==========no, i am dead;");
        }
    }

}
