// This is the classic Coin Change problem.
// Idea: Dynamic Programming (DP).
// Define dp[i] = the minimum number of coins needed to make up amount i.
// Initial: dp[0] = 0, and all other positions are initialized to ∞ (e.g., amount + 1).
// State transition:
// dp[i] = min(dp[i], dp[i - coin] + 1) (coin <= i)
// Final answer: If dp[amount] is still ∞, return -1; otherwise, return dp[amount].

// Time complexity: O(n * amount), where n = coins.length.
// Space complexity: O(amount).

import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // sentinel for "infinity"
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
