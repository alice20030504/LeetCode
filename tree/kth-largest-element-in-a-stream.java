// The kth largest element is the smallest element among the top k elements.
// Maintain a min-heap of size k:
// Heap always contains the k largest elements seen so far.
// The root (min) of the heap = kth largest element.
// Algorithm:
// Initialize heap with numbers. Keep only top k largest.
// On each add(val):
// Push val into heap.
// If heap size > k → remove smallest.
// Return heap root.

// Each add operation:
// Insert into heap: O(log k)
// Remove if size > k: O(log k)
// Total per operation: O(log k)
// Space: O(k)

import java.util.*;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(); // min-heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll(); // remove smallest
        }
        return minHeap.peek();
    }
}
