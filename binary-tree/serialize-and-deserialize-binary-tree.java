// Approach (DFS Preorder)
// Serialization:
// Traverse tree in preorder.
// Append node.val if not null, otherwise #.
// Separate with commas.
// Deserialization:
// Read tokens in order.
// If token is #, return null.
// Otherwise build a node and recursively build its left & right children.

// Time Complexity: O(n) for both serialization and deserialization (visit each node once).

// Space Complexity: O(n) for recursion + storing tokens.

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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(tokens));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    // ✅ Test function
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        String ser = codec.serialize(root1);
        System.out.println("Serialized: " + ser);
        TreeNode deser = codec.deserialize(ser);
        System.out.println("Re-Serialized: " + codec.serialize(deser));
        // Expected: same structure, "1,2,#,#,3,4,#,#,5,#,#,"

        // Example 2
        TreeNode root2 = null;
        String ser2 = codec.serialize(root2);
        System.out.println("Serialized empty: " + ser2);
        TreeNode deser2 = codec.deserialize(ser2);
        System.out.println("Re-Serialized empty: " + codec.serialize(deser2));
        // Expected: "#,"
    }
}
