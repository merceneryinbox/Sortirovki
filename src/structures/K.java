package structures;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 09.11.16
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */

/**
 * Created by Evgeny on 11.10.2016.
 */
public class K {
    private int[] heap;
    private int size = 0;

    K(int n) {
        heap = new int[n];
    }

    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private void siftUp(int i) {
        while (i != 0 && heap[i] > heap[(i - 1) >> 1]) {
            swap(i, (i - 1) >> 1);
            i = (i - 1) >> 1;
        }
    }

    private void siftDown(int i) {
        while ((i << 1) + 1 < size) {
            int left = (i << 1) + 1;
            int right = (i << 1) + 2;

            int j = left;
            if (right < size && heap[right] > heap[left]) {
                j = right;
            }

            if (heap[i] >= heap[j]) {
                break;
            }

            swap(i, j);
            i = j;
        }
    }

    void insert(int a) {
        heap[size++] = a;
        siftUp(size - 1);
    }

    int getMax() {
        if (size == 1) {
            return heap[--size];
        }

        int max = heap[0];

        heap[0] = heap[--size];
        siftDown(0);
        return max;
    }

    @Override
    public String toString() {
        String out = "";
        for (int k = 0; k < size; k++)
            out += heap[k] + " ";
        return out;
    }

}
