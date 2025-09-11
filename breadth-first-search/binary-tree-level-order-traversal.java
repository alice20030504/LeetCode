// Using Breadth-First Search (BFS):
// If the tree is empty → return [].
// Use a queue initialized with the root node.
// For each level:
// Get the current queue.length (that’s the number of nodes on this level).
// Process all nodes on this level, pushing their values into a level array.
// Add each node’s children (if they exist) into the queue for the next level.
// Push level into the result array res.

// Complexity
// Time Complexity: O(n), since each node is visited once.
// Space Complexity: O(n), because the queue can hold up to O(n) nodes in the worst case (a complete binary tree).

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

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }
}
