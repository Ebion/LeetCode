class Solution(object):
    def search(self, nums, target):
        if (len(nums) == 0):
            return -1;
        
        ## algo to find how many index it rotated by finding the smallest element in array
        left = 0;
        right = len(nums) - 1;
        while(right > left):
            midpoint = (left) + (right - left) / 2
            ## at the midpoint if it is more than the right side means smallest is at the right side
            if (nums[midpoint] > nums[right]):
                ## narrow down by setting left to midpoint + 1
                left = midpoint + 1;
            else:
                right = midpoint;
                
        ## rotated is the index where smallest exist
        rotated = left;
        left = 0;
        right = len(nums) - 1;
        
        # if target is within the smallest to the right side, search right
        if (nums[rotated] <= target and nums[right] >= target):
            left = rotated;
        else:
            ## else search left side
            right = rotated;
        
        ## here is normal binary search since either side will always be sorted
        while(left <= right):
            midpoint = (left) + (right - left) / 2
            if (nums[midpoint] == target):
                return midpoint;
            elif (nums[midpoint] < target):
                left = midpoint + 1;
            else:
                right = midpoint - 1;
        
        return -1;
            
        
            
        