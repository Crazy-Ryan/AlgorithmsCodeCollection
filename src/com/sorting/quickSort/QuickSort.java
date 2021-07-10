package com.sorting.quickSort;

import com.sorting.mergeSort.MergeSort;
import java.util.Arrays;

public class QuickSort {
    private static void sort(int[] arr, int startInd, int endInd) {
        int size = endInd - startInd + 1;
        if (size == 1) {
            return;
        }
        int firstGroupInd = startInd - 1;
        int thirdGroupInd = endInd + 1;
        int midItem = arr[startInd + size / 2];
        int ind = startInd;
        while (ind < thirdGroupInd) {
            if (arr[ind] > midItem) {
                thirdGroupInd--;
                swap(arr, thirdGroupInd, ind);
            } else {
                if (arr[ind] < midItem) {
                    firstGroupInd++;
                    if (ind > firstGroupInd) {
                        swap(arr,firstGroupInd, ind);
                    }
                }
                ind++;
            }
        }
        if (firstGroupInd != startInd - 1) {
            sort(arr, startInd, firstGroupInd);
        }
        if (thirdGroupInd != endInd + 1) {
            sort(arr, thirdGroupInd, endInd);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        QuickSort.sort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
