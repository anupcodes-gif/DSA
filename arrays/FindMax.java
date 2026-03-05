package arrays;

public class FindMax {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 9, 2};
        System.out.println("Array 1: [1, 5, 3, 9, 2]");
        System.out.println("Max Element: " + findMax(arr1, arr1.length));

        int[] arr2 = {-1, -5, -3, -9, -2};
        System.out.println("\nArray 2: [-1, -5, -3, -9, -2]");
        System.out.println("Max Element: " + findMax(arr2, arr2.length));
    }

    public static int findMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
