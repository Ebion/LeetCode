class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        set_ = set()
        for num in nums:
            if (num in set_):
                return num
            else:
                set_.add(num)
        