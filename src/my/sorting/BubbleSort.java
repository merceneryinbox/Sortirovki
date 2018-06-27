package my.sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 09.11.16
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public class BubbleSort {

    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i <= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 1, 45, 33, 21, 219, 19, 7, 25, 23, 55};

        System.out.println(Arrays.toString(array));

        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }
}
