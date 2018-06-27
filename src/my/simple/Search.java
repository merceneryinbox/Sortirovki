package my.simple;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 08.11.16
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class Search {

    static int linear(int[] a, int key) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }

    static int binary(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int middle;

        while (left < right) {
            middle = (left + right) / 2;
            if (a[middle] < key)
                left = middle + 1;
            else
                right = middle;
        }

        return a[right] == key ? right : -1;
    }

    public static void main(String[] args) {
        System.out.println(binary(new int[]{1, 2, 5, 7, 7, 7, 7, 23, 29, 29, 29, 29, 30}, 7));
    }
}
