package sorting.quickSort;

import java.util.Arrays;

public class ActualSampleAnswer {
    public static final int CUTOFF = 10;

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static int median3(int[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center] < a[left]) {
            swap(a, left, center);
        }
        if (a[right] < a[left]) {
            swap(a, left, right);
        }
        if (a[right] < a[center]) {
            swap(a, center, right);
        }

        swap(a, center, right - 1);
        return a[right - 1];
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            int pivot = median3(a, left, right);
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i] < a[pivot]) {
                }
                while (a[--j] > a[pivot]) {
                }
                if (i < j) {
                    swap(a, i, j);
                } else {
                    break;
                }
            }

            swap(a, i, right - 1);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        } else {
            insertionSort(a, left, right);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static void insertionSort(int[] a, int left, int right) {
        int j;
        for (int p = left; p <= right; p++) {
            int tmp = a[p];
            for (j = p; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] input = {8, 1, 4, 9, 0, 3, 5, 2, 7, 6};
        quickSort(input);
        System.out.println(Arrays.toString(input));
    }


}
