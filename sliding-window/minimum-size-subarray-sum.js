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
