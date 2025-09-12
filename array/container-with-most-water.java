// Key Idea
// A brute force solution would check all pairs (O(n²)) → too slow.
// Optimal Two-Pointer Technique:
// Start with two pointers at the extremes (left = 0, right = n-1).
// Compute area with these two lines.
// Move the pointer pointing to the shorter line inward, because the limiting factor is the shorter height.
// Keep track of the max area until the two pointers meet.

// Time Complexity: O(n), since each element is visited at most once by either pointer.
// Space Complexity: O(1), we only use a few variables.

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
