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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean tbc = true;
        while (tbc) {
            tbc = false;

            int r = -1;
            int c = q.size();
            for (int i = 0; i < c; i++) {
                TreeNode n = q.remove();
                if (n == null) continue;

                tbc = true;
                
                r = n.val;

                q.add(n.left);
                q.add(n.right);
            }

            if (tbc) result.add(r);
        }

        return result;
    }
}
