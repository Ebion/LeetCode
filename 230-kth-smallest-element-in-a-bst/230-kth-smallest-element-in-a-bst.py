# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    level = 0
    ans = -1
    
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.level = k
        self.helper(root)
        return self.ans
    
    def helper(self, root):
        if (root.left != None):
            self.helper(root.left)
        self.level = self.level - 1
        if (self.level == 0):
            #print(root.val, root)
            self.ans = root.val
        if (root.right != None):
            self.helper(root.right)