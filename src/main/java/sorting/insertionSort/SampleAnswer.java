package sorting.insertionSort;

public class SampleAnswer {
    private static void sort(int[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            int tmp = a[p];
            for (j = p; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
}
