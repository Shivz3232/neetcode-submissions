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
    public int goodNodes(TreeNode root) {

        int result = 0;
        // dfsI(root);
        // System.out.println();

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);

        Stack<Integer> s2 = new Stack<>();
        s2.push(root.val);

        while (!s1.isEmpty()) {
            TreeNode t = s1.pop();
            int max = s2.pop();

            if (t.val >= max) {
                result += 1;
            }

            if (t.left != null) {
                s1.push(t.left);
                s2.push(Math.max(t.left.val, max));
            }

            if (t.right != null) {
                s1.push(t.right);
                s2.push(Math.max(t.right.val, max));
            }
        }

        return result;
    }

    private void dfsR(TreeNode root) {
        if (root == null) {
            return;
        }

        dfsR(root.left);
        dfsR(root.right);

        System.out.print(root.val + ", ");
    }

    private void dfsI(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode t = s.pop();

            System.out.print(t.val + ", ");

            if (t.right != null) s.push(t.right);
            if (t.left != null) s.push(t.left);
        }
    }
}
