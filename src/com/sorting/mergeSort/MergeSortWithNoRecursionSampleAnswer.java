package com.sorting.mergeSort;

import java.util.Arrays;

public class MergeSortWithNoRecursionSampleAnswer {
    private static void mergeSort(int[] a) {
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        int n = a.length;
        for (int subListSize = 1; subListSize < n; subListSize *= 2) {
            int part1Start = 0;
            while (part1Start + subListSize < n) {
                int part2Start = part1Start + subListSize;
                int part2End = Math.min(n - 1, part2Start + subListSize - 1);
                merge(a, tmpArray, part1Start, part2Start, part2End);
                part1Start = part2End + 1;
            }
        }
    }

    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] < a[rightPos]) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        mergeSort(input);
        System.out.println(Arrays.toString(input));
    }
}
