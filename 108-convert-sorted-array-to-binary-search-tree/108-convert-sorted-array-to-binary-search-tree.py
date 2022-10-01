# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import numpy as np

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        return self.BST(nums, 0, len(nums) - 1)
    
    def BST(self, nums, left, right):
        if (left > right):
            return None
        midpoint = (left + right) // 2
        curr = TreeNode(nums[midpoint])
        curr.left = self.BST(nums, left, midpoint - 1)
        curr.right = self.BST(nums, midpoint + 1, right)
        return curr
        
        