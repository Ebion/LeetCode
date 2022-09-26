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
import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> output_arr = new ArrayList<Integer>();
        
        TreeNode current = root;
        if (root == null) {
            return output_arr;
        }
        
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            } 
            current = stack.pop();
            output_arr.add(current.val);
            current = current.right;
        }
        return output_arr;
    }
}














