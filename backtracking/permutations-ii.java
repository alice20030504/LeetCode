// This is the permutations with duplicates problem.
// If we use plain backtracking, we will generate duplicate permutations when numbers repeat.
// To avoid duplicates:
// Sort the array first.
// During backtracking, skip a number if it is the same as the previous number and the previous one hasn’t been used yet.

// Backtracking + sorting + skip rule




import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // skip already used
            if (used[i]) continue;
            // skip duplicates: ensure we only use the "first" unused duplicate
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, used, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
