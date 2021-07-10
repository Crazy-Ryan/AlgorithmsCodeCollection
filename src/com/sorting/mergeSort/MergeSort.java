package com.sorting.mergeSort;

import java.util.Arrays;

public class MergeSort {
    private static int[] sort(int[] input) {
        int inputSize = input.length;
        if (inputSize == 1) {
            return input;
        }
        int[] firstArr = sort(Arrays.copyOfRange(input, 0, inputSize / 2));
        int[] secondArr = sort(Arrays.copyOfRange(input, inputSize / 2, inputSize));

        int firstArrSize = firstArr.length;
        int secondArrSize = secondArr.length;
        int firstArrInd = 0;
        int secondArrInd = 0;
        for (int ind = 0; ind < inputSize; ind++) {
            if (secondArrInd == secondArrSize) {
                input[ind] = firstArr[firstArrInd];
                firstArrInd++;
            }
            else if (firstArrInd == firstArrSize) {
                input[ind] = secondArr[secondArrInd];
                secondArrInd++;
            }
            else if (firstArr[firstArrInd] < secondArr[secondArrInd]) {
                input[ind] = firstArr[firstArrInd];
                firstArrInd++;
            }
            else if (secondArr[secondArrInd] <= firstArr[firstArrInd]) {
                input[ind] = secondArr[secondArrInd];
                secondArrInd++;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        int[] result = MergeSort.sort(input);
        System.out.println(Arrays.toString(result));
    }

}
