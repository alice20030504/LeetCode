// This is equivalent to finding the longest subarray with at most 2 distinct numbers.
// We can use the sliding window technique with a HashMap to keep track of counts of fruit types inside the window.

// Steps:
// Initialize two pointers (left, right) and a map count to store fruit frequencies.
// Expand right → add fruits into the map.
// If map size > 2, shrink from left until map size ≤ 2.
// Track the max window size (right - left + 1).

// Time Complexity: O(n)
// Each fruit is added once and removed once.

// Space Complexity: O(1)
// The map stores at most 2 distinct fruit types.

import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);

            // Shrink window until only 2 types remain
            while (count.size() > 2) {
                count.put(fruits[left], count.get(fruits[left]) - 1);
                if (count.get(fruits[left]) == 0) {
                    count.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
