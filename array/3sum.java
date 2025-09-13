// Sort the array.
// Iterate i from 0..n-3.
// If i > 0 and nums[i] == nums[i-1], skip (to avoid duplicates).
// Use two pointers (l and r) to find pairs such that nums[i] + nums[l] + nums[r] == 0.
// If sum < 0 → move l++.
// If sum > 0 → move r--.
// If sum == 0 → store triplet, then move both pointers skipping duplicates.

// Complexity
// Sorting: O(n log n)
// Outer loop: O(n)
// Inner two-pointer search: O(n) per iteration
// Total: O(n²)
// Space: O(1) (ignoring result storage).

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates for i

            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++; // skip duplicate l
                    while (l < r && nums[r] == nums[r + 1]) r--; // skip duplicate r
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}
