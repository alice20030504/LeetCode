// Best Approach
// Backtracking with a visited array → avoids duplicate use of the same element.
// Alternatively, we can swap in-place, but the visited-array method is cleaner.

// Complexity Analysis

// Time Complexity:
// Number of permutations = n!
// Each permutation requires O(n) to build (list copy).
// Total: O(n * n!)

// Space Complexity:
// Recursion depth: O(n)
// Used array: O(n)
// Result storage: O(n * n!)

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        // base case: one complete permutation
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // try each unused element
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, used, result);
            // undo choice
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
