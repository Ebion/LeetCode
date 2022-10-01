# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    stack = []
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        while (root != None):
            self.stack.append(root)
            root = root.left
        
    def next(self) -> int:
        node = self.stack.pop()
        ans = node.val
        
        if node.right:
            node = node.right
            
            while node:
                self.stack.append(node)
                node = node.left
        
        return ans
        
        
    def hasNext(self) -> bool:
        if (len(self.stack) != 0):
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()