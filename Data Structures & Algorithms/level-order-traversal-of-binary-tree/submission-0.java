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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();

        boolean tbc = true;
        q.add(root);
        while (tbc) {
            // display(result);

            tbc = false;
            int count = q.size();
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i < count; i++) {
                TreeNode n = q.remove();

                if (n == null) {
                    q.add(null);
                    q.add(null);
                    temp.add(null);
                } else {
                    tbc = true;

                    q.add(n.left);
                    q.add(n.right);
                    temp.add(n.val);
                }
            }

            if (tbc) result.add(temp);
        }
        // display(result);

        return result;
    }

    private void display(List<List<Integer>> result) {
        System.out.print("[");
        for (List<Integer> l : result) {
            System.out.print("[");
            for (int i : l) {
                System.out.print(i + ", ");
            }
            System.out.print("]");
        }
        System.out.println("]");
    }
}
