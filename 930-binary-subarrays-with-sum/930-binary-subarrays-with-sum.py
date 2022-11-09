class Solution(object):
    
    def numSubarraysWithSum(self, nums, goal):
        """
        :type nums: List[int]
        :type goal: int
        :rtype: int
        """
        
        return self.numSubarrayswithSumEqualOrLessThanTarget(nums, goal) - self.numSubarrayswithSumEqualOrLessThanTarget(nums, goal - 1);
    
    def numSubarrayswithSumEqualOrLessThanTarget(self, nums, goal):
        if goal < 0:
            return 0
        preSum = 0
        result = 0
        start = 0
        for end in range(len(nums)):
            preSum += nums[end]
            while preSum > goal:
                preSum -= nums[start]
                start += 1
            result += end - start + 1
        return result