// We are asked to reconstruct a binary tree from its preorder and inorder traversal sequences.
// Preorder gives us the root order (root → left → right).
// Inorder gives us subtree separation (left → root → right).
// The first element in preorder is always the root.
// By finding that root’s index in inorder, we can split into left and right subtrees.
// Then recursively build subtrees.
// To optimize, we use a HashMap to store each value’s index in inorder for O(1) lookup instead of O(n) scanning.

// Time Complexity:
// Each node is processed once → O(n).
// HashMap lookup is O(1).

// Space Complexity:
// HashMap → O(n)
// Recursion stack in worst case (skewed tree) → O(n)
// Overall → O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    private Map<Integer, Integer> inorderMap;
    private int preIndex = 0; // current index in preorder

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null; // base case

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderMap.get(rootVal);

        root.left = helper(preorder, inLeft, mid - 1);
        root.right = helper(preorder, mid + 1, inRight);

        return root;
    }
}
