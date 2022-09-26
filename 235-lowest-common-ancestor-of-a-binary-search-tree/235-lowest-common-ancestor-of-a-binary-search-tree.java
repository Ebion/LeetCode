/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = null;
        TreeNode right = null;
        if (p.val < q.val) {
            left = p;
            right = q;
        } else {
            left = q;
            right = p;
        }
        if (left.val == root.val) {
            return root;
        } else if (right.val == root.val) {
            return root;
        } else if (left.val < root.val && root.val < right.val) {
            return root;
        } else if (right.val < root.val) { 
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        } 
    }
}