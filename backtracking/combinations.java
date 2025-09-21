// Best Approach
// Backtracking with pruning:
// Start with start = 1.
// At each recursion, loop from start to n.
// Append number, recurse with start = i + 1.
// Stop when path.size() == k.

// Complexity Analysis
// Number of combinations = C(n, k) = n! / (k!(n-k)!).
// Each combination requires O(k) to copy.
// Time Complexity: O(k * C(n, k)).
// Space Complexity:
// Recursion depth = O(k).
// Result storage = O(k * C(n, k)).

import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int start, int n, int k) {
        // if path has k numbers, add to result
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // pruning: i <= n - (k - path.size()) + 1 ensures enough numbers left
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(result, path, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
