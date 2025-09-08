//This question is a typical two-pointer problem: the array is sorted so that it can be scanned from the beginning to the end and from the end to the middle at the same time.If the sum of the two numbers is greater than the target, the right pointer is shifted left; if it is less than the target, the left pointer is shifted right; when they are equal, that is the answer.
//Time complexity: O(n), scan the whole array at most once.
//Space complexity: O(1), only constant variables are used to store pointers.
/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {
    let left = 0, right = numbers.length - 1;

    while (left < right) {
        let sum = numbers[left] + numbers[right];
        if (sum === target) {
            return [left + 1, right + 1]; // to 1-indexed
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return [];
};


