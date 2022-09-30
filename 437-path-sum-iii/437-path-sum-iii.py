# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    counter = 0;
    d = {}
    target = 0;
    
    def pathSum(self, root, targetSum):
        self.target = targetSum;
        self.d[0] = 1;
        self.dfs(root, 0);
        return self.counter;
    
    def dfs(self, root, curSum):
        if (root == None):
            return None
        
        ##current sum of the root to leaf
        curSum = curSum + root.val
        
        #if the difference of target - sum exists = path exist
        if (self.d.get(curSum - self.target) != None):
            # add in all paths that exist
            self.counter = self.counter + self.d.get(curSum - self.target)
        
        #add in the sum into dictionary
        if (self.d.get(curSum) != None):
            self.d[curSum] = self.d.get(curSum) + 1
        else: 
            self.d[curSum] = 1
        
        #recurse down to left and right from root seperatly
        self.dfs(root.left, curSum);
        self.dfs(root.right,curSum);
        
        #remove the root, check from levels below the root
        if (self.d.get(curSum) == 1):
            self.d.pop(curSum)
        else:
            self.d[curSum] = self.d.get(curSum) - 1
            