package sorting.bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    private static int[] sort(int[] input) {
        int size = input.length;
        for (int ind = 0; ind < size - 1; ind++) {
            for (int index = 0; index < size - ind - 1; index++) {
                if (input[index] > input[index + 1]) {
                    swap(input, index, index + 1);
                }
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
        int[] input = {34, 8, 64, 51, 32, 21};
        int[] result = BubbleSort.sort(input);
        System.out.println(Arrays.toString(result));
    }
}
