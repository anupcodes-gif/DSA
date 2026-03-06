package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class MTBinarySearch {
    private static AtomicInteger foundIndex = new AtomicInteger(-1);

    static class SearchTask implements Runnable {
        int[] arr;
        int target, low, high;

        SearchTask(int[] arr, int target, int low, int high) {
            this.arr = arr; this.target = target; this.low = low; this.high = high;
        }

        public void run() {
            int l = low, h = high;
            while (l <= h && foundIndex.get() == -1) {
                int mid = l + (h - l) / 2;
                if (arr[mid] == target) {
                    foundIndex.set(mid);
                    return;
                }
                if (arr[mid] < target) l = mid + 1;
                else h = mid - 1;
            }
        }
    }

    public int search(int[] arr, int target, int numThreads) throws InterruptedException {
        int n = arr.length;
        Thread[] threads = new Thread[numThreads];
        int segmentSize = n / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int low = i * segmentSize;
            int high = (i == numThreads - 1) ? n - 1 : (i + 1) * segmentSize - 1;
            threads[i] = new Thread(new SearchTask(arr, target, low, high));
            threads[i].start();
        }

        for (Thread t : threads) t.join();
        return foundIndex.get();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 15;
        MTBinarySearch mbs = new MTBinarySearch();
        int index = mbs.search(arr, target, 2);

        System.out.println("Array: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]");
        System.out.println("Target: " + target);
        System.out.println("Found at index: " + index);
    }
}
