package chapter6.chapter6_3;

public class Test2 {
    
    public static void main(String[] args) {
        System.out.println(new Test2().t());
    }
    
    public int t() {
        int i;
        try {
            i = 1;
            e();
            return i;
        } catch (Exception e) {
            i = 2;
            return i;
        }finally {
            i = 3;
            System.out.println("finally " + i);
        }
    }
    
    public void e() {
        throw new Error();
    }
    
}