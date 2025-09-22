// Problem Analysis
// We need to restore valid IP addresses from a string of digits.
// An IP address must have 4 parts separated by ".".

// Each part:
// Between 0 and 255.
// No leading zeros unless the part is exactly "0".
// We must insert exactly 3 dots in the string.
// This is a backtracking problem:
// At each step, cut the string into a segment of length 1–3.
// Validate the segment.
// Recurse until we have 4 segments.
// If we used all characters, add to result.

// Best Approach
// Backtracking with pruning:
// Stop early if segment count > 4.
// Stop early if remaining characters can’t possibly form valid segments.

// Complexity Analysis
// Time Complexity:
// At most 3 choices per segment, 4 segments → O(3^4) = O(81) possible segmentations.
// Each validation and join is O(1) per segment.
// Overall ≈ O(1) bounded by constant (since max string length = 20).
// Space Complexity:
// Recursion depth: O(4)
// Path storage: O(4)
// Result storage: depends on number of valid IPs, but bounded (less than a few hundred).

import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<String> result, List<String> path, String s, int start) {
        // if we already have 4 parts
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // try segments of length 1 to 3
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String segment = s.substring(start, start + len);
            if (isValid(segment)) {
                path.add(segment);
                backtrack(result, path, s, start + len);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String segment) {
        // no leading zeros unless "0"
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }
}
