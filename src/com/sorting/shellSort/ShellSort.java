package com.sorting.shellSort;

import com.sorting.bubbleSort.BubbleSort;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ShellSort {
    private static int[] sort(int[] input) {

        int size = input.length;
        for (int interval = size / 2; interval > 0; interval /= 2) {
            for (int index = 0; index < size; index += interval) {
                int minIndex = index;
                for (int ind = index; ind < size; ind += interval) {
                    if (input[ind] < input[minIndex]) {
                        minIndex = ind;
                    }
                }
                swap(input, minIndex, index);
            }
        }
        return input;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
//        int[] input = {34, 8, 64, 51, 32, 21};
        int[] input = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(startTime);
        int[] result = ShellSort.sort(input);
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(endTime);
        System.out.println("Time: "+ Duration.between(startTime, endTime).getNano());
        System.out.println(Arrays.toString(result));
    }

}
