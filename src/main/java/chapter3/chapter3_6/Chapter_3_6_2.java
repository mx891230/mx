package chapter3.chapter3_6;

/**
 * jvm args(-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC)
 * 特别加入了-XX:+UseSerialGC参数，手动使用serial和serial old组合，因为parallel好像不支持XX:PretenureSizeThreshold参数
 * @author Mengx
 *
 */
public class Chapter_3_6_2 {
    
    private static final int _1MB = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

}
