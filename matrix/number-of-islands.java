// Problem Analysis
// We need to count how many connected components of land ('1') exist in a 2D grid.
// Connected means adjacent horizontally or vertically (not diagonally).
// Each time we find a land cell '1', we can run DFS/BFS to mark the entire island as visited.
// Finally, count how many times we initiate a search.
// This is the classic "Number of Islands" problem → solved with DFS / BFS / Union-Find.

// Complexity Analysis
// Time Complexity:
// Each cell is visited at most once.
// O(m * n).
// Space Complexity:
// Recursion depth = O(m * n) in worst case (all land).
// Iterative BFS version would use a queue of size up to O(m * n).


class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;

        grid[i][j] = '0'; // mark visited

        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }
}
