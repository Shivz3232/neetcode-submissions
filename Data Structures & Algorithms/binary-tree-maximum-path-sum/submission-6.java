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
    private int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;

        int m = dfs(root);

        return Math.max(result, m);
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int m = Math.max(
            node.val,
            Math.max(
                left + right + node.val,
                Math.max(
                    left + node.val,
                    right + node.val
                )
            )
        );

        if (m > result) result = m;

        return Math.max(
            node.val,
            Math.max(
                left + node.val,
                right + node.val
            )
        );
    }
}
