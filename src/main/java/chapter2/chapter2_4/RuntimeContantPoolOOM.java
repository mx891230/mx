package chapter2.chapter2_4;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池，JDK1.6及以前版本会报错，JDK1.7及以后版本不会
 * jvm args(-XX:PermSize=10M -XX:MaxPermSize=10M)
 * @author Mengx
 *
 */
public class RuntimeContantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while(true) {
            list.add(String.valueOf(i++).intern());
        }
        
//        String str1 = new StringBuilder("�����").append("���").toString();
//        System.out.println(str1.intern() == str1);
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
    }

}
