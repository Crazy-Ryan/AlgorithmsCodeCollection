package com.sorting.heapSort;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class SampleAnswer {
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void percDown(int[] a, int i, int n) {
        int child;
        int tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child] < a[child + 1]) {
                child++;
            }
            if (tmp < a[child]) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    public static void heapSort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swapReference(a, 0, i);
            percDown(a, 0, i);
        }
    }

    private static void swapReference(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(startTime);
        heapSort(input);
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(endTime);
        System.out.println("Time: " + Duration.between(startTime, endTime).getNano());
        System.out.println(Arrays.toString(input));
    }
}

