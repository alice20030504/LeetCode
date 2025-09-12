// We want the k-th smallest element in a BST.
// Key property: Inorder traversal of a BST gives sorted values.
// So the straightforward approach is:
// Do an inorder traversal.
// Stop when we reach the k-th element.
// This avoids collecting all elements in an array (saves memory).

// Time Complexity: O(h + k)
// h = height of tree
// We traverse down the leftmost path (O(h)) and pop nodes until k-th node (O(k)).

// Space Complexity: O(h) for the stack (worst case O(n) if skewed tree).


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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // go left as far as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--; // visit node
            if (k == 0) return curr.val;
            curr = curr.right; // move to right subtree
        }
        return -1; // should never reach here if k is valid
    }
}
