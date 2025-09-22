// Problem Analysis
// We need the minimum number of minutes to rot all fresh oranges in a grid.
// A rotten orange spreads to adjacent fresh oranges every minute.
// This is essentially a multi-source BFS problem:
// All initially rotten oranges are sources.
// Spread simultaneously level by level (minute by minute).
// If some fresh oranges are unreachable, return -1.

// Best Approach
// BFS with a queue:
// Add all rotten oranges (2) into queue initially.
// Count total number of fresh oranges.
// Perform BFS:
// For each rotten orange, rot its fresh neighbors.
// Decrease fresh count.
// Track time (levels of BFS).
// If fresh = 0 → return minutes elapsed.
// Otherwise → return -1.

// Complexity Analysis
// Time Complexity: O(m * n)
// Each cell is visited at most once.
// Space Complexity: O(m * n) for BFS queue in worst case.
// Alternatives
// DFS simulation is not suitable because infection spreads simultaneously (BFS is natural).
// BFS ensures we capture the "minute by minute" spread correctly.


import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: add all rotten oranges to queue, count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // if no fresh oranges
        if (fresh == 0) return 0;

        int minutes = -1; // track time (start at -1 because first level = 0 min)
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];

                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1) continue;
                    grid[nx][ny] = 2; // rot this orange
                    fresh--;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
