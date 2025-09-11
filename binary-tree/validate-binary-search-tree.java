// Idea
// To validate a BST:
// Use recursion with value ranges:
// Each node has a valid interval (min, max) that its value must fall into.
// Initially: (−∞, +∞)
// If we go left: (min, root.val)
// If we go right: (root.val, max)
// If at any point a node violates this rule → return false.

// Time Complexity: O(n)
// Each node is visited once.

// Space Complexity:
// Recursive stack = O(h), where h = tree height.
// Worst case: skewed tree → O(n).
// Best case: balanced tree → O(log n).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return helper(node.left, min, node.val) &&
               helper(node.right, node.val, max);
    }
}
