// We need to perform a zigzag level order traversal of a binary tree.
// This is basically a BFS (level order traversal), but at each level we reverse the order depending on whether the level is odd or even.
// Root → left to right. Next level → right to left. Alternate each level.
// Approach:
// Use a queue for BFS.
// Track current level size.
// Use a LinkedList to insert nodes either at the end (normal order) or at the front (reverse order).

// Time Complexity: O(n), each node visited once.

// Space Complexity: O(n) for queue and output list.

import java.util.*;

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

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight; // alternate direction
        }

        return result;
    }

    // ✅ Test function
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(sol.zigzagLevelOrder(root1));
        // Expected [[3], [20, 9], [15, 7]]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println(sol.zigzagLevelOrder(root2));
        // Expected [[1]]

        // Example 3
        System.out.println(sol.zigzagLevelOrder(null));
        // Expected []
    }
}
