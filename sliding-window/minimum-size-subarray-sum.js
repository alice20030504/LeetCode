/*Problem Restatement:
Given an array nums of positive integers and a target value target.
Find the minimum length of a contiguous subarray such that:
sum(subarray)>=target
If no subarray exists, return 0.

Since all numbers are positive, we can use a sliding window:
Expand right pointer to grow sum.
Shrink from the left pointer while sum ≥ target.
Keep track of the minimal length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */

function minSubArrayLen(target, nums) {
    let n = nums.length;
    let left = 0, sum = 0, minLen = Infinity;

    for (let right = 0; right < n; right++) {
        sum += nums[right];

        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left++];
        }
    }

    return minLen === Infinity ? 0 : minLen;
}
