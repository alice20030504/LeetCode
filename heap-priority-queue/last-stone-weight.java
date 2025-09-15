// Max-Heap (PriorityQueue in Java with reverse order).
// Always need the two largest elements efficiently.
// Each extraction is O(log n).
// Constraints are small (n ≤ 30), but heap is the cleanest approach.

// Time Complexity: O(n log n)
// Insert all stones: O(n log n).
// Each smash = 2 polls + maybe 1 offer = O(log n).
// Up to n smashes.

// Space Complexity: O(n) for the heap.

import java.util.*;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // 2nd heaviest
            if (y != x) {
                maxHeap.offer(y - x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
