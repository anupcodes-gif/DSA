package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int element) {
        int size = q.size();
        q.add(element);
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }
        return q.remove();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        
        System.out.println("Pushing: 10, 20, 30");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.print("Popping: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
