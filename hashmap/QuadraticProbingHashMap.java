package hashmap;

public class QuadraticProbingHashMap {
    static class Entry {
        int key;
        String value;
        Entry(int k, String v) { key = k; value = v; }
    }

    private Entry[] table;
    private int size;
    private int capacity;

    public QuadraticProbingHashMap(int cap) {
        capacity = cap;
        table = new Entry[capacity];
        size = 0;
    }

    private int hash(int key) { return key % capacity; }

    public void insert(int key, String value) {
        if (size == capacity) {
            System.out.println("HashMap Full");
            return;
        }
        int i = 0;
        int h = hash(key);
        while (i < capacity) {
            int idx = (h + i * i) % capacity;
            if (table[idx] == null || table[idx].key == key) {
                if (table[idx] == null) size++;
                table[idx] = new Entry(key, value);
                return;
            }
            i++;
        }
    }

    public String search(int key) {
        int i = 0;
        int h = hash(key);
        while (i < capacity) {
            int idx = (h + i * i) % capacity;
            if (table[idx] == null) return "Not found";
            if (table[idx].key == key) return table[idx].value;
            i++;
        }
        return "Not found";
    }

    public static void main(String[] args) {
        QuadraticProbingHashMap map = new QuadraticProbingHashMap(7);
        map.insert(1, "Value1");
        map.insert(8, "Value2"); // Collision with 1
        map.insert(15, "Value3"); // Collision with 1

        System.out.println("Search(1): " + map.search(1));
        System.out.println("Search(8): " + map.search(8));
        System.out.println("Search(15): " + map.search(15));
        System.out.println("Search(2): " + map.search(2));
    }
}
