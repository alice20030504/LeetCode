// Problem Analysis
// We need to capture surrounded regions in a grid of 'X' and 'O'.
// A region of 'O' is surrounded if none of its cells touch the border.
// That means:
// All 'O's connected to the border must stay unchanged.
// All other 'O's must be flipped to 'X'.

// Strategy:
// Mark all 'O's connected to the border (they are safe).
// Use DFS/BFS/Union-Find.
// Mark them with a temporary char (e.g., '#').
// After marking:
// Flip all remaining 'O' → 'X'.
// Flip all '#' → 'O'.

// Complexity Analysis
// Time Complexity:
// Each cell visited at most once.
// O(m * n).
// Space Complexity:
// DFS recursion depth = O(m * n) worst case (stack overflow risk if grid is very large).
// For BFS (queue-based), also O(m * n) in worst case.


class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        // Step 1: mark border-connected 'O's
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, m, n);
            dfs(board, m - 1, j, m, n);
        }

        // Step 2: flip captured regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;
        board[i][j] = '#'; // mark as safe
        dfs(board, i + 1, j, m, n);
        dfs(board, i - 1, j, m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i, j - 1, m, n);
    }
}
