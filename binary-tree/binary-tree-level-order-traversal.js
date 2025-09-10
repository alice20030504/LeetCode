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
 * function TreeNode(val, left, right) {
 *     this.val = (val === undefined ? 0 : val);
 *     this.left = (left === undefined ? null : left);
 *     this.right = (right === undefined ? null : right);
 * }
 */

/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (!root) return [];

    const res = [];
    const queue = [root];

    while (queue.length > 0) {
        const levelSize = queue.length;
        const level = [];

        for (let i = 0; i < levelSize; i++) {
            const node = queue.shift();
            level.push(node.val);

            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        res.push(level);
    }

    return res;
};
