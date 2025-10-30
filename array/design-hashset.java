// The set is represented as an array of buckets (LinkedList<Integer>[]).

// Each bucket handles potential collisions using separate chaining (a linked list).

// Hash function:
// key % SIZE

// Efficiency:

// Fast and memory-friendly for small key ranges.

// Trade-off: fixed bucket count (1000) → slight slowdown if many keys hash to the same bucket.

// A larger SIZE improves time performance but increases space cost.

// maps each key to a bucket index.

// Each operation (add, remove, contains) only interacts with its bucket —
// efficient even with many keys.

// Operation	Average Time	Worst Time	Space Complexity	Explanation
// add()/remove()/contains()	O(n / SIZE)	O(n)	O(n)	Usually constant time; collisions handled in linked lists

import java.util.*;

class MyHashSet {
    private final int SIZE = 1000;     // Number of buckets
    private LinkedList<Integer>[] buckets; // Each bucket is a linked list for chaining

    // Constructor: initialize buckets
    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function: simple modulo operation
    private int hash(int key) {
        return key % SIZE;
    }

    // Adds a key to the HashSet
    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        if (!bucket.contains(key)) {
            bucket.add(key); // Only add if not already present
        }
    }

    // Removes a key from the HashSet
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        bucket.remove(Integer.valueOf(key)); // Remove by value, not index
    }

    // Checks if a key exists in the HashSet
    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        return bucket.contains(key);
    }
}
