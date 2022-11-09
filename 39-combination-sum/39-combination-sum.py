class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        
        start from last element and if cannot subtract move on
        """
        end = len(candidates)
        answer = []
        
        def helper(curr_sum, arr, start):
            if (curr_sum == target): 
                # finished 1 combination, append to answer
                answer.append(arr)
                return 
            if (curr_sum > target):
                # exceed the target, this combination fails
                return 

            for i in range(start, end):
                helper(curr_sum + candidates[i], arr + [candidates[i]], i)
        
        helper(0, [], 0)
        return answer