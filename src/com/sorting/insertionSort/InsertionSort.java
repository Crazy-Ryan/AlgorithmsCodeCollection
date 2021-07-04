package com.sorting.insertionSort;

import java.util.Arrays;

public class InsertionSort {

    private static int[] sort(int[] input) {
        int size = input.length;
        int[] result = new int[size];
        if (size == 0) {
            return result;
        }
        result[0] = input[0];
        for (int index = 1; index < size; index++) {
            int itemToInsert = input[index];
            int currentItemCount = index;
            int position = 0;
            for (int ind = 0; ind < currentItemCount; ind++) {
                if (result[ind] < itemToInsert) {
                    position = ind + 1;
                }
            }
            for (int ind = currentItemCount - 1; ind >= position; ind--) {
                result[ind + 1] = result[ind];
            }
            result[position] = itemToInsert;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        int[] result = InsertionSort.sort(input);
        System.out.println(Arrays.toString(result));
    }
}
