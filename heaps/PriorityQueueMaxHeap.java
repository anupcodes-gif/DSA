package heaps;

import java.util.ArrayList;

public class PriorityQueueMaxHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    public void insert(int value) {
        heap.add(value);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMax() {
        if (heap.size() == 0) {
            System.out.println("Empty");
            return -1;
        }
        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }

    private void heapifyDown(int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < heap.size() && heap.get(l) > heap.get(largest)) largest = l;
        if (r < heap.size() && heap.get(r) > heap.get(largest)) largest = r;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    private int parent(int i) { return (i - 1) / 2; }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() { return heap.isEmpty(); }

    public static void main(String[] args) {
        PriorityQueueMaxHeap pq = new PriorityQueueMaxHeap();
        System.out.println("Inserting: 10, 20, 15, 30, 40");
        pq.insert(10);
        pq.insert(20);
        pq.insert(15);
        pq.insert(30);
        pq.insert(40);

        System.out.print("Extracting max: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.extractMax() + " ");
        }
        System.out.println();
    }
}
