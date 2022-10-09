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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            // if only 1 side is null but the other is not
            return false;
        }
        if (p.val != q.val) {
            // check if value of nodes are equal
            return false;
        }
        
        // recurse the left and right
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}