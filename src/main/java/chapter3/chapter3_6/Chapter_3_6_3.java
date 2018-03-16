package chapter3.chapter3_6;

/**
 * jvm args(-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+UseSerialGC)
 * 此测试请使用JDK7u6或之前的版本，7U6与之后的JDK版本不知道为什么XX:MaxTenuringThreshold无法生效
 * @author Mengx
 *
 */
public class Chapter_3_6_3 {
    
    private static final int _1MB = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

}
