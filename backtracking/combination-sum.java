// Best Approach
// Backtracking with index control:
// At each step, try picking a candidate number starting from start index.
// Stay at the same index if reusing the same number is allowed.
// If the running sum exceeds target, prune.
// If the running sum equals target, add to result.

// Complexity Analysis
// Let T = target, n = number of candidates.
// Worst-case branching: each candidate can be chosen many times.
// Time Complexity: exponential in general (backtracking), bounded by number of valid combinations (<150 by problem constraint). Roughly O(n^(T/minCandidate)) in the worst case.
// Space Complexity:
// Recursion depth up to T / minCandidate.
// Result storage size = output size (≤150).

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(path)); // found a valid combination
            return;
        }
        if (remain < 0) return; // exceed target, stop

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            // allow reuse, so keep i as the next start
            backtrack(result, path, candidates, remain - candidates[i], i);
            path.remove(path.size() - 1); // undo choice
        }
    }
}
