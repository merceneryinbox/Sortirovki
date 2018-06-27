package structures;

/**
 * Created with IntelliJ IDEA.
 * User: andreyd
 * Date: 09.11.16
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
public class BinaryHeap {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] heap;
    private int size = 0;

    public BinaryHeap() {
        heap = new int[DEFAULT_CAPACITY];
    }

    private void siftDown(int i) {
        while (2 * i + 1 < size) {     // heapSize — количество элементов в куче
            int left = 2 * i + 1;            // left — левый сын
            int right = 2 * i + 2;            // right — правый сын
            int j = left;

            if (right < size && heap[right] > heap[left])
                j = right;

            if (heap[i] >= heap[j])
                break;

            swap(i, j);
            i = j;
        }
    }

    private void siftUp(int i) {
        while (i != 0 && heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void swap(int a, int b) {
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

    public void insert(int key) {
        heap[size++] = key;
        siftUp(size - 1);
    }

    public int getPeek() {
        if (size == 1)
            return heap[--size];

        int peek = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return peek;
    }

    @Override
    public String toString() {
        String out = "";
        for (int k = 0; k < size; k++)
            out += heap[k] + " ";
        return out;
    }

    public static void main(String[] args) {
        BinaryHeap bh = new BinaryHeap();

        bh.insert(5);
        bh.insert(3);
        bh.insert(1);
        bh.insert(2);
        bh.insert(10);
        bh.insert(4);
        bh.insert(6);

        System.out.println(bh.toString());
        K k = new K(10);
        k.insert(5);
        k.insert(3);
        k.insert(1);
        k.insert(2);
        k.insert(10);
        System.out.println(k.toString());
    }
}
