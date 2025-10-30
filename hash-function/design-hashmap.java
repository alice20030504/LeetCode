// Key Idea

// A hash table uses an array of “buckets.”

// Each bucket stores a linked list of key–value pairs to handle collisions.

// Hashing by key % SIZE allows constant-time average access.

// Updating an existing key means scanning its bucket and changing value.

// Complexity (Responsibility) Analysis
// Operation	Average Time	Worst Time	Space Complexity	Explanation
// put()/get()remove()	O(1)	O(n)	O(n)	Hash to a bucket, usually small; worst = all keys collide in one bucket

// Efficiency & Trade-off:

// Average performance is constant-time thanks to uniform hashing.

// Worst case (bad hash distribution) degrades to linear search.

// Choosing a suitable SIZE and a good hash function minimizes collisions.

import java.util.*;

class MyHashMap {

    /** Number of buckets (array slots). 
     *  A larger number reduces collisions but uses more memory. */
    private final int SIZE = 1000;

    /** Each bucket is a LinkedList storing key–value pairs. */
    private LinkedList<Pair>[] buckets;

    /** A simple inner class representing a key–value pair. */
    private static class Pair {
        int key, value;
        Pair(int k, int v) { key = k; value = v; }
    }

    /** Initialize empty HashMap. */
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /** Basic hash function: maps key → index. */
    private int hash(int key) {
        return key % SIZE;
    }

    /** Insert (key, value) into the HashMap.
     *  If key already exists, update its value. */
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Pair> bucket = buckets[index];

        for (Pair p : bucket) {
            if (p.key == key) {
                p.value = value; // Update existing
                return;
            }
        }
        bucket.add(new Pair(key, value)); // Insert new
    }

    /** Return the value associated with key, or –1 if not found. */
    public int get(int key) {
        int index = hash(key);
        LinkedList<Pair> bucket = buckets[index];

        for (Pair p : bucket) {
            if (p.key == key) return p.value;
        }
        return -1;
    }

    /** Remove key (and its value) if present. */
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Pair> bucket = buckets[index];

        Iterator<Pair> it = bucket.iterator();
        while (it.hasNext()) {
            if (it.next().key == key) {
                it.remove();
                return;
            }
        }
    }
}
