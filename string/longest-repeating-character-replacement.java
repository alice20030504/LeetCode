// Idea: We use a sliding window.
// Expand the right pointer and count the frequency of characters in the window.
// Keep track of the most frequent character count in the window (say maxCount).
// If (window length - maxCount) > k, it means we need more than k changes → shrink from left.
// Keep updating the max window size.

// Time Complexity:
// O(n), because each character is processed at most twice (right pointer expands, left pointer shrinks).

// Space Complexity:
// O(26) = O(1), since we only store counts of uppercase English letters.

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // store frequency of letters
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // If more than k chars need to be replaced, shrink window
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
