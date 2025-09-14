// We want the maximum path sum in a binary tree.
// A path can start and end anywhere (not necessarily at the root).
// At each node, we can form a path:
// Either go down one side (left or right) → continue path upward.
// Or form a “split” path: left → node → right (this could be the global max).

// Key idea: Recursion
// For each node, compute the max gain that can be extended upward:
// node.val + max(0, left_gain, right_gain)
// At the same time, compute a candidate path sum including both children:
// node.val + max(0, left_gain) + max(0, right_gain)
// Update a global maximum.

// Time Complexity: O(n), each node visited once.

// Space Complexity: O(h), recursion stack (worst-case h = n for skewed tree).


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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // compute max gain from left and right, discard negatives
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);

        // path passing through this node
        int currentPath = node.val + leftGain + rightGain;

        // update global max
        maxSum = Math.max(maxSum, currentPath);

        // return max gain if we continue upward
        return node.val + Math.max(leftGain, rightGain);
    }

    // ✅ Test function
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(sol.maxPathSum(root1));
        // Expected 6 (2 -> 1 -> 3)

        // Example 2
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println(sol.maxPathSum(root2));
        // Expected 42 (15 -> 20 -> 7)
    }
}
