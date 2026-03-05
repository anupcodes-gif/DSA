package sorting;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        randomizedQuickSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array:   " + Arrays.toString(arr));
        
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("\nAlready sorted: " + Arrays.toString(sortedArr));
        randomizedQuickSort(sortedArr, 0, sortedArr.length - 1);
        System.out.println("Result:         " + Arrays.toString(sortedArr));

        int[] reverseArr = {5, 4, 3, 2, 1};
        System.out.println("\nReverse sorted: " + Arrays.toString(reverseArr));
        randomizedQuickSort(reverseArr, 0, reverseArr.length - 1);
        System.out.println("Result:         " + Arrays.toString(reverseArr));
    }

    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, p - 1);
            randomizedQuickSort(arr, p + 1, high);
        }
    }

    private static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int randIdx = rand.nextInt(high - low + 1) + low;
        swap(arr, randIdx, high);
        return partition(arr, low, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
