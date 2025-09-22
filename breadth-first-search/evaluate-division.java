// Problem Analysis
// We are given equations like a / b = value.
// This naturally forms a weighted graph:
// Each variable is a node.
// Each equation creates two directed edges:
// a → b with weight value
// b → a with weight 1/value
// For each query c / d, we want the path product from c to d.
// If no path exists, return -1.0.

// Best Approach
// Graph + DFS/BFS
// Build adjacency list with weights.
// For each query, run DFS/BFS:
// Multiply edge weights along the path.
// If we reach target, return product.
// If unreachable, return -1.0.

// Complexity Analysis
// Time Complexity:
// Building graph: O(E) where E = equations.length.
// Query DFS: worst-case O(V + E) per query.
// With ≤ 20 equations and ≤ 20 queries → very efficient.
// Space Complexity:
// Graph: O(V + E)
// Recursion stack + visited: O(V).

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: build graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        // Step 2: process queries
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, start, end, 1.0, visited);
            }
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double accProduct, Set<String> visited) {
        if (curr.equals(target)) return accProduct;
        visited.add(curr);

        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            if (visited.contains(neighbor.getKey())) continue;
            double res = dfs(graph, neighbor.getKey(), target, accProduct * neighbor.getValue(), visited);
            if (res != -1.0) return res;
        }
        return -1.0;
    }
}

