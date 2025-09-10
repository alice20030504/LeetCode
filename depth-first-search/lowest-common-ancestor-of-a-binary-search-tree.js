/*In a Binary Search Tree:
For any node root:
All nodes in the left subtree < root.val
All nodes in the right subtree > root.val
So for two nodes p and q:
If both p.val and q.val < root.val → LCA must be in the left subtree
If both p.val and q.val > root.val → LCA must be in the right subtree
Otherwise (they split, or one equals root) → root is the LCA

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    while (root !== null) {
        if (p.val < root.val && q.val < root.val) {
            root = root.left;
        } else if (p.val > root.val && q.val > root.val) {
            root = root.right;
        } else {
            return root;
        }
    }
    return null;
};
