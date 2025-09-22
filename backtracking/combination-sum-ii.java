// Problem Analysis
// This is the Combination Sum II problem.
// Key points:
// Each candidate number can only be used once.
// Input may contain duplicates → we must avoid duplicate combinations in the output.
// Unlike Combination Sum I, we must move forward (i+1) in recursion so numbers aren’t reused.

// To handle duplicates:
// Sort the array first.
// Skip duplicate candidates at the same recursive depth.

// Complexity Analysis
// Time Complexity:
// Worst case: O(2^n) (each element can be chosen or not).
// With pruning and skipping duplicates, practical runtime is much smaller.
// Space Complexity:
// Recursion depth: O(n)
// Result storage: depends on number of valid combinations.


import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0) return; // exceed target → stop

        for (int i = start; i < candidates.length; i++) {
            // skip duplicates at the same recursion depth
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            // move to i+1 because each number can only be used once
            backtrack(result, path, candidates, remain - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
