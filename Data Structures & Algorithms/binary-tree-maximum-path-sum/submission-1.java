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
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;

        return maxPathSumDfs(root, 0);
    }

    private int maxPathSumDfs(TreeNode root, int sum) {
        if (root == null) return 0;

        int left = maxPathSumDfs(root.left, root.val);
        int right = maxPathSumDfs(root.right, root.val);

        return Math.max(
            root.val,
            Math.max(
                left + right + root.val,
                Math.max(
                    left,
                    right
                )
            )
        );
    }
}
