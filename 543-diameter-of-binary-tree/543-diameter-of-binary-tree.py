# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
	    self.diameter = 0
        
    def diameterOfBinaryTree(self, root):
        if (root):
            self.findDeepest(root);
            return self.diameter;
        else:
            return 0;
        
    def findDeepest(self, root):
        if (root):
            left = self.findDeepest(root.left);
            right = self.findDeepest(root.right);
            if (left + right > self.diameter):
                self.diameter = left + right
            return max(left, right) + 1;
        else:
            return 0;
        