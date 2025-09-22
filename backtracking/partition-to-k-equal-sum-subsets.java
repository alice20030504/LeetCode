// Problem Analysis
// We need to check if the array can be partitioned into k subsets of equal sum.
// Key points:
// First check: if sum(nums) % k != 0, return false immediately.
// Each subset must sum to target = sum(nums) / k.
// This is a subset partitioning problem → classic backtracking with pruning.
// Since nums.length ≤ 16, we can also use bitmask + memoization to speed up.

// Best Approach
// Backtracking with sorting (descending order) + pruning
// Sort descending to place larger numbers first (reduces branching).
// Keep an array buckets[k] representing the current sum of each subset.
// Try to place each number into a bucket if it fits (bucket[i] + num <= target).
// Use backtracking until all numbers are placed.
// Prune: if buckets[i] == 0 after trying, break to avoid symmetric duplicates.

// Complexity Analysis
// Time Complexity:
// Worst case exponential: O(k^n) (each number tries k buckets).
// With pruning + sorting, practical performance is much better.
// Works for n ≤ 16.
// Space Complexity:
// Buckets: O(k)
// Recursion depth: O(n)

import java.util.*;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) return false;
        int target = total / k;

        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > target) return false; // largest number too big

        int[] buckets = new int[k];
        return backtrack(nums, n - 1, buckets, target);
    }

    private boolean backtrack(int[] nums, int index, int[] buckets, int target) {
        if (index < 0) return true; // all numbers placed
        int num = nums[index];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + num <= target) {
                buckets[i] += num;
                if (backtrack(nums, index - 1, buckets, target)) return true;
                buckets[i] -= num;
            }
            // pruning: if bucket is empty, no need to try others
            if (buckets[i] == 0) break;
        }
        return false;
    }
}
