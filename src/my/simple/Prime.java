package my.simple;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 08.11.16
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public class Prime {
    static boolean isPrime(int n) {
        for (int i = 2; i < (int) Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }

    static int modpow(long a, long e, long n) {
        int result = 1;

        while (e > 0) {
            if ((e & 1) == 1) {
                result = (int)((result * a) % n);
            }
            a = (a * a) % n;
            e >>= 1;
        }

        return result;
    }

    static long gcd(long p, long q) {
        long temp;
        while (q != 0) {
            temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    static boolean testFermat(long x) {
        Random rand = new Random();

        if (x == 2)
            return true;

        long a;
        for (int i = 0; i < 100; i++) {
            a = rand.nextInt((int)(x - 2)) + 2;

            if (gcd(a, x) != 1)
                return false;

            if (modpow(a, x - 1, x) != 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(gcd(12,8));
    }
}
