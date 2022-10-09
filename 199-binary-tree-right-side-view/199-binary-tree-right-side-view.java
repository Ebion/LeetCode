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
        List<Integer> result = new ArrayList<Integer>();
        int level = 0;
        
        rightTraversal(root, result, level);
        return result;
    }
    
    public void rightTraversal(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return ;
        }
        
        if (level == result.size()) {
            result.add(root.val);
        }
        
        level++;
        rightTraversal(root.right,result,level);
        rightTraversal(root.left,result,level);
    }
}