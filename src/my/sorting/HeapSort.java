package my.sorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by andreyd on 22.11.2016.
 */
public class HeapSort {

    private static class BinHeap {
        private ArrayList<Integer> heap;

        BinHeap() {
            this.heap = new ArrayList<>();
        }

        BinHeap(int[] arr) {
            this.heap = new ArrayList<>();

            for (int a : arr) {
                this.insert(a);
            }
        }

        private void swap(int i, int j) {
            int t = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, t);
        }

        private void siftUp(int i) {
            while (i != 0 && heap.get(i) < heap.get((i - 1) >> 1)) {
                swap(i, (i - 1) >> 1);
                i = (i - 1) >> 1;
            }
        }

        private void siftDown(int i) {
            while ((i << 1) + 1 < heap.size()) {
                int left = (i << 1) + 1;
                int right = (i << 1) + 2;

                int j = left;

                if (right < heap.size() && heap.get(right) < (heap.get(left))) {
                    j = right;
                }

                if (heap.get(i) <= heap.get(j)) {
                    break;
                }

                swap(i, j);
                i = j;
            }
        }

        void insert(int a) {
            heap.add(a);
            siftUp(heap.size() - 1);
        }

        int getMin() {
            if (heap.size() == 1) {
                return heap.remove(0);
            }

            int max = heap.get(0);

            heap.set(0, heap.remove(heap.size() - 1));
            siftDown(0);
            return max;
        }
    }

    static void sort(int[] array) {
        BinHeap bh = new BinHeap(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = bh.getMin();
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] ss = input.nextLine().split(" ");

        int[] a = new int[ss.length];
        int i = 0;

        for (String s : ss) {
            a[i++] = Integer.valueOf(s);
        }
        sort(a);

        StringBuilder sb = new StringBuilder();
        for (int aa : a) {
            sb.append(aa).append(" ");
        }
        System.out.println(sb.toString());
    }
}
