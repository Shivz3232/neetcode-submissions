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
    public boolean isValidBST(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        inorder(root, traversal);

        for (int i = 1; i < traversal.size(); i++) {
            if (traversal.get(i - 1) >= traversal.get(i)) return false;
        }

        return true;
    }

    private void inorder(TreeNode root, List<Integer> traversal) {
        if (root == null) return;

        inorder(root.left, traversal);
        traversal.add(root.val);
        inorder(root.right, traversal);
    }
}
