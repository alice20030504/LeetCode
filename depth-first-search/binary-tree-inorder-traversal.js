// Problem Type & Intuition
// This is a binary tree traversal problem, specifically asking for inorder traversal (Left → Node → Right).
// Recursive solution is straightforward: recursively visit left subtree, then node, then right subtree.
// Iterative solution is trickier: we simulate recursion using a stack.

// Time & Space Complexity
// Time Complexity: O(n), since each node is visited exactly once.

// Space Complexity:
// Recursive: O(h), where h is the tree height (stack depth). Worst case O(n).
// Iterative: O(h) as well, since we explicitly use a stack.

var inorderTraversal = function(root) {
    let result = [];

    function dfs(node) {
        if (!node) return;
        dfs(node.left);
        result.push(node.val);
        dfs(node.right);
    }

    dfs(root);
    return result;
};
