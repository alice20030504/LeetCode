// Problem Analysis
// We want to check if all rooms can be visited starting from room 0.
// Each room may contain keys to other rooms.
// This forms a graph traversal problem:
// Nodes = rooms.
// Edges = keys (from room i to room j).
// The task: is the graph connected from node 0?

// Best Approach
// Use DFS or BFS:
// Start from room 0.
// Keep a visited set/array.
// Traverse neighbors using keys.
// At the end, check if all rooms are visited.

// Complexity Analysis
// Time Complexity: O(n + E)
// n = number of rooms
// E = total number of keys (≤ 3000 by constraint).
// Space Complexity:
// O(n) for visited array + recursion stack.


import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room]) return;
        visited[room] = true;
        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited);
        }
    }
}
