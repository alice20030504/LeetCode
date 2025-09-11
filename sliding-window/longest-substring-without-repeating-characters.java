// Approach
// Use the sliding window technique with a HashMap (or HashSet):
// Keep a left pointer (left) and expand a right pointer (right).
// Use a map to store the last index of each character.
// If a duplicate is found:
// Move the left pointer to Math.max(left, lastIndex + 1) so the substring remains valid.
// Update the max length at each step.
// Complexity Analysis

// Time Complexity: O(n)
// Each character is visited at most twice (once by right, once by left).

// Space Complexity: O(min(n, charset))
// At most one entry per unique character. Since the input can contain ASCII characters, it’s O(128) → effectively O(1).

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                // move left pointer to avoid duplicates
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right); // update last index
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
