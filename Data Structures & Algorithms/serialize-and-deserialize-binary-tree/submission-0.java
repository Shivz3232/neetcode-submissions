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
        List<String> l = new ArrayList<>();

        serializeDfs(root, l);

        return String.join(",", l);
    }

    private void serializeDfs(TreeNode node, List<String> l) {
        if (node == null) {
            l.add("N");
            return;
        }

        l.add(String.valueOf(node.val));
        serializeDfs(node.left, l);
        serializeDfs(node.right, l);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] i = {0};
        return deserializeDfs(data.split(","), i);
    }

    private TreeNode deserializeDfs(String[] data, int[] i) {
        if (data[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data[i[0]]));

        i[0]++;

        node.left = deserializeDfs(data, i);
        node.right = deserializeDfs(data, i);

        return node;
    }
}
