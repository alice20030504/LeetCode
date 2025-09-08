/*This is a two-pointer, in-place array modification problem.
Since the array is sorted in non-decreasing order, all duplicates are grouped together.
We use one slow pointer (k) to track the next position to write a unique element, and a fast pointer (i) to scan through the array.
Whenever a new (different) element is found, write it to nums[k] and increment k.

Time & Space Complexity
Time Complexity: O(n), because we only traverse the array once.
Space Complexity: O(1), since we modify the array in place without extra storage.
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (nums.length === 0) return 0;

    let k = 1; // slow pointer: next write position
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[i - 1]) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
};

// Test cases