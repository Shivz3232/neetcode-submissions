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

class Solution {
    private int preorderI;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, m, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> m, int l, int r) {
        if (l > r) return null;

        int val = preorder[preorderI++];

        TreeNode root = new TreeNode(val);

        root.left = buildTree(preorder, inorder, m, l, m.get(val) - 1);
        root.right = buildTree(preorder, inorder, m, m.get(val) + 1, r);

        return root;
    }
}
