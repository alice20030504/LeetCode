// Approach (Backtracking)
// Maintain two counters:
// open → how many '(' have been used.
// close → how many ')' have been used.
// At each step:
// If open < n, we can add '('.
// If close < open, we can add ')'.
// Base case: when string length = 2n, add to result.

// Time Complexity:
// Number of valid parentheses combinations is a lot more larger than O(n^2)
// #the number of valid outputs is exponential in n, not linear.

// Space Complexity:
// Recursion depth: O(n)
// Result storage: O(C_n)

import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String curr, int open, int close, int n) {
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        if (open < n) {
            backtrack(result, curr + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(result, curr + ")", open, close + 1, n);
        }
    }
}