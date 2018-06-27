package my.simple;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 08.11.16
 * Time: 0:34
 * To change this template use File | Settings | File Templates.
 */
public class Swap {
    static void swap1(int a, int b) {
        int temp = b;
        b = a;
        a = temp;
        System.out.println(a + " " + b);
    }

    static void swap2(int a, int b) {

        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a + " " + b);
    }

    static void swap3(int a, int b) {
        a += b;
        b = a - b;
        a -= b;
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        swap3(5,10);
    }
}
