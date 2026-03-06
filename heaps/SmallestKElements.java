package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestKElements {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Array: [7, 10, 4, 3, 20, 15], k = 3");
        System.out.println("Smallest " + k + " elements: " + findSmallestK(arr, k));
    }

    public static List<Integer> findSmallestK(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : arr) {
            minHeap.add(x);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            result.add(minHeap.poll());
        }
        return result;
    }
}
