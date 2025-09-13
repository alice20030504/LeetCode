// Approach (Sorting + Two Pointers)
// Sort nums.
// Fix the first two indices i and j using nested loops.
// Skip duplicates for i and j.
// For the remaining part, use two pointers (l, r).
// If sum < target → move l++.
// If sum > target → move r--.
// If sum == target → record quadruplet, move both pointers skipping duplicates.

// Time Complexity：
// Sorting: O(n log n)
// Double loop (i, j): O(n²)
// Two pointers per loop: O(n)
// Total: O(n³) (feasible for n=200).

// Space Complexity： 
// O(1) (ignoring output).

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates for i
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates for j

                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r]; // prevent overflow
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++; // skip duplicate l
                        while (l < r && nums[r] == nums[r + 1]) r--; // skip duplicate r
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }

    // ✅ Test function
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,0,-1,0,-2,2};
        System.out.println(sol.fourSum(nums1, 0)); 
        // Expected [[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]

        int[] nums2 = {2,2,2,2,2};
        System.out.println(sol.fourSum(nums2, 8)); 
        // Expected [[2,2,2,2]]
    }
}
