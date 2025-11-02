class MyHashMap {

    // Node class for linked list
    private static class Node {
        int key, value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000; // number of buckets
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    // Insert or update (key, value)
    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1); // dummy head
        }

        Node prev = find(buckets[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value); // key not found → insert
        } else {
            prev.next.value = value;          // key found → update
        }
    }

    // Retrieve value for given key
    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) return -1;

        Node prev = find(buckets[index], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) return;

        Node prev = find(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    // Helper to find previous node of target key
    private Node find(Node head, int key) {
        Node curr = head, prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}
