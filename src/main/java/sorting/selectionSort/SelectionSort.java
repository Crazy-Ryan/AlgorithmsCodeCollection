package sorting.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    private static int[] sort(int[] input) {
        int size = input.length;
        for (int ind = 0; ind < size; ind++) {
            int minIndex = ind;
            for (int index = ind + 1; index < size; index++) {
                if (input[index] < input[minIndex]) {
                    minIndex = index;
                }
            }
            int tmp = input[ind];
            input[ind] = input[minIndex];
            input[minIndex] = tmp;
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        int[] result = SelectionSort.sort(input);
        System.out.println(Arrays.toString(result));
    }
}
