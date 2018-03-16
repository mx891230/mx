package chapter4.chapter4_3;

import java.io.IOException;
/**
 * 启用jconsole.exe监控线程的内存情况
 * @author Mengx
 *
 */
public class Chapter4_10 {
    
    static class SynAddRunable implements Runnable {
        int a,b;
        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunable(1, 2)).start();
            new Thread(new SynAddRunable(2, 1)).start();
        }
    }
}
