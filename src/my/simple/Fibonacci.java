package my.simple;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 07.11.16
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {

    //n >= 2
    static int iterative(int n) {
        if (n < 2)
            return n;

        int prev = 0;
        int next = 1;
        //int fib = prev + next;
        for (int i = 2; i <= n; i++) {
            //fib = prev + next;
            next += prev;
            prev = next - prev;
        }
        return next;
    }

    static int recursive(int n) {
        if (n < 2)
            return n;
        else
            return recursive(n-1)+recursive(n-2);
    }
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++)
            System.out.println(i + " = " +iterative(i));
    }
}
