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
    public int kthSmallest(TreeNode root, int k) {
        Probe p = new Probe();

        inorder(root, k, p);

        return p.result;
    }

    private void inorder(TreeNode root, int k, Probe p) {
        if (root == null) return;

        inorder(root.left, k, p);

        p.i += 1;
        if (p.i == k) {
            p.result = root.val;
            return;
        }

        inorder(root.right, k, p);
    }

    private static class Probe {
        public int i;
        public int result;
    }
}
