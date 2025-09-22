// Problem Analysis
// This is the Course Schedule problem.
// Courses form a directed graph.
// prerequisites[i] = [a, b] means an edge b → a (must take b before a).
// The question: can we finish all courses? ⇔ Is the graph acyclic?
// If there is a cycle, you cannot finish all courses.
// If it’s a DAG (Directed Acyclic Graph), you can.
// So the task reduces to cycle detection in a directed graph.

// Best Approach
// We can solve using Topological Sort (Kahn’s Algorithm):
// Build graph adjacency list + in-degree count for each node.
// Start with all nodes of in-degree = 0 (no prerequisites).
// Remove them from the graph, decreasing neighbors’ in-degree.
// If we process all nodes, return true. Otherwise, there’s a cycle → return false.

// Complexity Analysis
// Time Complexity:  
// Building graph: O(V + E)  
// BFS traversal: O(V + E)  
// Total: O(V + E) where V = numCourses, E = prerequisites.length.  
// Space Complexity:  
// Graph adjacency list: O(V + E)  
// Indegree array + queue: O(V)  


import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        // in-degree array
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

        int taken = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            taken++;
            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        return taken == numCourses;
    }
}
