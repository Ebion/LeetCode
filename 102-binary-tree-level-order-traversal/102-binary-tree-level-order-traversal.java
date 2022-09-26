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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if (root == null) {
            return result;
        }
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            List<Integer> lvl_arr = new ArrayList<Integer>();
            int curr_q_len = queue.size();
            for (int i = 0; i < curr_q_len; i++) {
                TreeNode curr = queue.poll();
                lvl_arr.add(curr.val);
                
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            
            result.add(lvl_arr);
        }
        
        return result;
    }
}