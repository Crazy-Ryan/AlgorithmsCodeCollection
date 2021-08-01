package sorting.heapSort;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class HeapSort {
    private static void sort(int[] arr) {
        buildHeap(arr);
        int size = arr.length;
        while(size > 0){
            int tmp = arr[0];
            deleteMin(arr, size);
            arr[size - 1] = tmp;
            size--;
        }

    }

    private static void buildHeap(int[] arr) {
        int size = arr.length;
        for (int ind = size - 1; ind >= 0; ind--) {
            percolateDown(arr, ind);
        }
    }

    private static void deleteMin(int[] arr, int size) {
        percolateUp(arr, size, 0);
    }

    private static void percolateUp(int[] arr, int size, int pos) {
        int lastNodeIndex = size - 1;
        int lastNodeValue = arr[lastNodeIndex];
        int leftChildPos = 2 * pos + 1;
        int rightChildPos = 2 * pos + 2;
        if (rightChildPos < size) {
            if (lastNodeValue < Math.max(arr[leftChildPos], arr[rightChildPos])) {
                if (arr[leftChildPos] > arr[rightChildPos]) {
                    arr[pos] = arr[leftChildPos];
                    percolateUp(arr, size, leftChildPos);
                } else {
                    arr[pos] = arr[rightChildPos];
                    percolateUp(arr, size, rightChildPos);
                }
            } else {
                arr[pos] = lastNodeValue;
            }
            return;
        }
        arr[pos] = lastNodeValue;

    }


    private static void percolateDown(int[] arr, int pos) {
        int size = arr.length;
        int leftChildPos = 2 * pos + 1;
        int rightChildPos = 2 * pos + 2;
        if (rightChildPos < size) {
            if (arr[pos] < Math.max(arr[leftChildPos], arr[rightChildPos])) {
                if (arr[leftChildPos] > arr[rightChildPos]) {
                    swap(arr, pos, leftChildPos);
                    percolateDown(arr, leftChildPos);
                } else {
                    swap(arr, pos, rightChildPos);
                    percolateDown(arr, rightChildPos);
                }
            }
        }
        if (rightChildPos == size) {
            if (arr[pos] < arr[leftChildPos]) {
                swap(arr, pos, leftChildPos);
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(startTime);
        HeapSort.sort(input);
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(endTime);
        System.out.println("Time: " + Duration.between(startTime, endTime).getNano());
        System.out.println(Arrays.toString(input));
    }
}
