// Problem Analysis
// This is Course Schedule II.
// We must find a valid ordering of courses such that prerequisites are respected.
// This is exactly topological sorting of a directed graph.
// If a cycle exists → no valid ordering → return empty array.

// Best Approach
// Kahn’s Algorithm (BFS Topological Sort)

// Complexity Analysis
// Time Complexity:
// Build graph: O(V + E)
// BFS traversal: O(V + E)
// Total: O(V + E)
// (V = numCourses, E = prerequisites.length)
// Space Complexity:
// Graph adjacency list: O(V + E)
// Indegree array + queue: O(V)
// Result array: O(V)

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[idx++] = curr;

            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        return idx == numCourses ? order : new int[0];
    }
}
