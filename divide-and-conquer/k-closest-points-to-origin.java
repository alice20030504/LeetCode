// Approaches:
// Sort by distance → O(n log n), then take first k.
// Heap (better for large n, small k):
// Use a max-heap of size k to store the k closest points.
// Push new points, and if size > k, remove the farthest.
// Result is the k closest points.
// Complexity: O(n log k).

// Time Complexity:
// Each insertion/removal in heap: O(log k).
// For n points → O(n log k).

// Space Complexity: O(k).

import java.util.*;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max heap: store [distance, index], sorted by distance (largest first)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            int dist = x * x + y * y;
            maxHeap.offer(new int[]{dist, i});
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int idx = maxHeap.poll()[1];
            res[i] = points[idx];
        }
        return res;
    }
}
