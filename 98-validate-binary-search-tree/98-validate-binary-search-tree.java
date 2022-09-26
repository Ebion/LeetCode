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
    
    ArrayList<Integer> inorder = new ArrayList<Integer>();
    
    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        int prev = inorder.get(0);
        for (int i = 1; i < inorder.size(); i++) {
            int curr = inorder.get(i);
            if (curr <= prev) {
                return false;
            } else {
                prev = curr;
            }
        }
        return true;
    }
    
    public void inOrderTraversal(TreeNode root) {
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        inorder.add(root.val);
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }
}