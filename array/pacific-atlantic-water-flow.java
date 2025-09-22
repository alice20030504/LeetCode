// Problem Analysis
// We want cells that can flow water to both Pacific (top/left borders) and Atlantic (bottom/right borders).
// Rule: water can flow from a cell to a neighbor with lower or equal height.
// Instead of simulating from each cell (expensive), we can reverse the flow:
// Start from the oceans and mark all cells that can flow into them by moving only to neighbors of greater or equal height.
// Pacific search: start from top row and left column.
// Atlantic search: start from bottom row and right column.
// The answer = intersection of the Pacific-reachable set and the Atlantic-reachable set.

// Best Approach
// DFS or BFS from the oceans
// For each ocean, run DFS/BFS and mark reachable cells.
// Finally, collect all cells marked by both searches.

// Complexity Analysis
// Time Complexity:
// Each cell is visited at most twice (Pacific + Atlantic) → O(m * n).
// Space Complexity:
// Two m × n boolean matrices → O(m * n).
// Recursion depth up to O(m * n) worst case.

import java.util.*;

class Solution {
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // DFS from Pacific border (top row, left col)
        for (int i = 0; i < m; i++) dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
        for (int j = 0; j < n; j++) dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
        
        // DFS from Atlantic border (bottom row, right col)
        for (int i = 0; i < m; i++) dfs(heights, atlantic, i, n-1, Integer.MIN_VALUE);
        for (int j = 0; j < n; j++) dfs(heights, atlantic, m-1, j, Integer.MIN_VALUE);
        
        // Collect results
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return; // cannot flow uphill
        
        visited[r][c] = true;
        for (int[] d : dirs) {
            dfs(heights, visited, r + d[0], c + d[1], heights[r][c]);
        }
    }
}
