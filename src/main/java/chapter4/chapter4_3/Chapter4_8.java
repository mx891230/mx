package chapter4.chapter4_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * 启用jconsole.exe监控线程的内存情况
 * @author Mengx
 *
 */
public class Chapter4_8 {
    
    static class OOMObject {
        public byte[] b = new byte[64 * 1024];
    }

    
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for(int i = 0; i < num; i++) {
            TimeUnit.MILLISECONDS.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        fillHeap(1000);
//        System.gc();
        System.out.println("in");
        System.in.read();
    }
}
