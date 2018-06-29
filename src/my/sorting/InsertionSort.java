package my.sorting;

class InsertionSrtt {

    public static void main(String[] args) {
        int[] ar = {152, 654, 2, 0, 153, 2, 1, 55, 6, 85, 56};
        int n = ar.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && ar[j - 1] > ar[j]; j--) {
                swap(j - 1, j, ar);
            }
        }
        printArray(ar);
    }

    private static void printArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    private static void swap(int less, int more, int[] arrayTemp) {
        int tempInt = arrayTemp[less];
        arrayTemp[less] = arrayTemp[more];
        arrayTemp[more] = tempInt;
    }
}