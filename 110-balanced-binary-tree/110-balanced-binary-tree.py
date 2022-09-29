# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        if (not root):
            return True;
        if (root):
            height_left = self.findHeight(root.left);
            height_right = self.findHeight(root.right);
        diff = abs(height_left - height_right)
        if (height_left < 0 or height_left < 0):
            return False;
        if (diff <= 1):
            return True;
        else:
            return False;
    
    def findHeight(self, root):
        if (root):
            height_left = self.findHeight(root.left) + 1;
            height_right = self.findHeight(root.right) + 1;
            diff = abs(height_left - height_right)
            print(height_left, height_right)
            if (diff > 1):
                return -20;
            else:
                if (height_left > height_right):
                    return height_left;
                else:
                    return height_right;
        else:
            return 0;
        