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
        return maxPathSumDfs(root, 0);
    }

    private int maxPathSumDfs(TreeNode root, int sum) {
        if (root.left != null && root.right != null) {
            int left = maxPathSumDfs(root.left, root.val);
            int right = maxPathSumDfs(root.right, root.val);

            return Math.max(
                root.val,
                Math.max(
                    left + right + root.val,
                    Math.max(
                        left,
                        Math.max(
                            left + root.val,
                            Math.max(
                                right,
                                right + root.val
                            )
                        )
                    )
                )
            );
        } else if (root.right != null) {
            int right = maxPathSumDfs(root.right, root.val);

            return Math.max(
                root.val,
                Math.max(
                    right,
                    right + root.val
                )
            );
        } else if (root.left != null) {
            int left = maxPathSumDfs(root.left, root.val);

            return Math.max(
                root.val,
                Math.max(
                    left,
                    left + root.val
                )
            );
        } else {
            return root.val;
        }
    }
}
