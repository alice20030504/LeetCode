// Problem Analysis
// We need to partition the string into substrings such that each substring is a palindrome.
// This is a backtracking problem:
// At each step, cut the string at position i.
// If s[start..i] is a palindrome, recurse from i+1.
// When we reach the end, add the current path as one valid partition.
// To optimize palindrome checking:
// Either check substring each time in O(length)
// Or precompute a DP table isPalindrome[start][end].

// Complexity Analysis
// Time Complexity:
// In worst case (s = "aaaa..."), every cut is valid.
// Number of partitions = exponential (close to 2^(n-1) possible cuts).
// Palindrome check per substring = O(n).
// Total worst-case ≈ O(n * 2^n).
// Space Complexity:
// Recursion depth: O(n)
// Path storage: O(n)
// Result storage: output size dominates, exponential.

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> path, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(result, path, s, end + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
