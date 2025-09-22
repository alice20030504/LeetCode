// Problem Analysis
// We need to find all root-to-leaf paths in a binary tree where the sum equals targetSum.
// A leaf = node with no children.
// This is a backtracking DFS problem:
// Traverse from root downwards.
// Maintain a running path and current sum.
// If a leaf is reached and the sum matches targetSum, record the path.
// Backtrack (remove the last node) after exploring each branch.

// Complexity Analysis
// Time Complexity:
// Visits each node once → O(n), where n = number of nodes.
// Each root-to-leaf path copy = O(h) where h = tree height.
// Worst case: O(n * h) (in skewed tree).
// Space Complexity:
// Recursion depth = O(h)
// Path storage = O(h)
// Result storage = O(#paths * h)

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int remain, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        // include current node in path
        path.add(node.val);

        // check if it's a leaf and the sum matches
        if (node.left == null && node.right == null && remain == node.val) {
            result.add(new ArrayList<>(path));
        } else {
            // continue to left and right children
            dfs(node.left, remain - node.val, path, result);
            dfs(node.right, remain - node.val, path, result);
        }

        // backtrack
        path.remove(path.size() - 1);
    }
}
