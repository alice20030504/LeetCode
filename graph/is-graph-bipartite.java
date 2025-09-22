// Problem Analysis
// We need to check if an undirected graph is bipartite.
// A graph is bipartite if we can color all nodes with two colors (say 0 and 1) such that no two adjacent nodes share the same color.
// Equivalently: No odd-length cycle exists.
// The graph may be disconnected, so we must check every connected component.

// Best Approach
// Use graph coloring with BFS/DFS:
// Maintain a color[] array initialized with -1 (uncolored).
// For each unvisited node, assign it a color (0), then BFS/DFS.
// For each neighbor:
// If uncolored, assign opposite color.
// If already colored and same as current → not bipartite → return false.
// If all nodes are colored without conflict → return true.

// Complexity Analysis
// Time Complexity: O(V + E)
// V = number of nodes, E = number of edges.
// Each node and edge is processed once.
// Space Complexity:
// O(V) for color array and BFS queue.

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 = uncolored

        for (int start = 0; start < n; start++) {
            if (color[start] != -1) continue; // already visited
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            color[start] = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int nei : graph[node]) {
                    if (color[nei] == -1) {
                        color[nei] = 1 - color[node]; // assign opposite color
                        queue.offer(nei);
                    } else if (color[nei] == color[node]) {
                        return false; // conflict found
                    }
                }
            }
        }
        return true;
    }
}
