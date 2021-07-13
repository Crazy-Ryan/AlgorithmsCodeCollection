package com.sorting.mergeSort;

import java.util.Arrays;

public class MergeSortWithNoRecursion {
    private static int[] sort(int[] input) {
        int inputSize = input.length;
        if (inputSize == 1) {
            return input;
        }

        int groupSize = 1;
        while (true) {
            groupSize *= 2;

            int groupCount = inputSize / groupSize;
            if (inputSize % groupSize != 0) {
                groupCount++;
            }
            for (int groupInd = 0; groupInd < groupCount; groupInd++) {
                int arrSize = groupSize / 2;
                int groupStartInd = groupInd * groupSize;
                int groupEndInd = Math.min((groupInd + 1) * groupSize - 1, inputSize - 1);
                int firstArrStartInd = groupStartInd;
                int firstArrEndInd = Math.min(firstArrStartInd + arrSize - 1, groupEndInd);
                int secondArrStartInd = Math.min(firstArrEndInd + 1, groupEndInd);
                int secondArrEndInd = Math.min(secondArrStartInd + arrSize - 1, groupEndInd);

                int firstArrInd = 0;
                int secondArrInd = 0;
                int[] firstArr = Arrays.copyOfRange(input, firstArrStartInd, firstArrEndInd + 1);
                int[] secondArr = Arrays.copyOfRange(input, secondArrStartInd, secondArrEndInd + 1);
                for (int ind = groupStartInd; ind <= groupEndInd; ind++) {
                    if (secondArrInd == secondArr.length) {
                        input[ind] = firstArr[firstArrInd];
                        firstArrInd++;
                    } else if (firstArrInd == firstArr.length) {
                        input[ind] = secondArr[secondArrInd];
                        secondArrInd++;
                    } else if (firstArr[firstArrInd] < secondArr[secondArrInd]) {
                        input[ind] = firstArr[firstArrInd];
                        firstArrInd++;
                    } else if (secondArr[secondArrInd] <= firstArr[firstArrInd]) {
                        input[ind] = secondArr[secondArrInd];
                        secondArrInd++;
                    }
                }
            }
            if (groupSize > inputSize) {
                break;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 65, 77, 89, 21};
        int[] result = MergeSortWithNoRecursion.sort(input);
        System.out.println(Arrays.toString(result));
    }
}
