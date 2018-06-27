package my.sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 09.11.16
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort  {

    public static void sort(int[] values) {
        // Check for empty or null array
        if (values == null || values.length==0){
            return;
        }
        quicksort(values, 0, values.length - 1);
    }

    private static void quicksort(int[] values, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = values[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (values[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (values[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we swap the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(values, i++, j--);
            }
        }
        // Recursion
        if (low < j)
            quicksort(values, low, j);
        if (i < high)
            quicksort(values, i, high);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,2,6,5,1};

        System.out.println(Arrays.toString(array));

        new QuickSort().sort(array);
        System.out.println(Arrays.toString(array));
    }
}