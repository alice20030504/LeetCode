// Problem Analysis
// We are asked to deep copy a connected undirected graph.
// Each node may have multiple neighbors.
// We need to create entirely new nodes with the same values and neighbor relationships.
// The challenge: avoid infinite loops when revisiting nodes (because graphs can have cycles).

// Complexity Analysis
// Time Complexity:
// Each node and edge is visited once → O(V + E)
// V = number of nodes, E = number of edges.
// Space Complexity:
// HashMap stores O(V) mappings.
// Recursion depth up to O(V) in worst case.


import java.util.*;

// Definition for a Node.
class Solution {
    public int val;
    public List<Node> neighbors;
    public Node() {
        neighbors = new ArrayList<Node>();
    }
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If already cloned, return it
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create clone node
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        // Clone all neighbors recursively
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
