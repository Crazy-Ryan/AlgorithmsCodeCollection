package sorting.insertionSort;

import java.util.Arrays;

public class InsertionSortV2 {

    private static int[] sort(int[] input) {
        int size = input.length;
        for (int index = 0; index < size; index++) {
            int itemToInsert = input[index];
            int position = 0;
            for (int ind = 0; ind < index; ind++) {
                if (input[ind] < itemToInsert) {
                    position = ind + 1;
                }
            }
            for (int ind = index - 1; ind >= position; ind--) {
                input[ind + 1] = input[ind];
            }
            input[position] = itemToInsert;
        }
        return input;
    }


    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        int[] result = InsertionSortV2.sort(input);
        System.out.println(Arrays.toString(result));
    }

}
