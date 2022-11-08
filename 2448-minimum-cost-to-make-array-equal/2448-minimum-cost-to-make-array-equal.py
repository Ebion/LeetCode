class Solution(object):
    def minCost(self, nums, cost):
        """
        :type nums: List[int]
        :type cost: List[int]
        :rtype: int
        """
        tuple_arr = []
        total_cost = 0
        for i in range(0, len(nums)):
            number = nums[i]
            costs = cost[i]
            tuple_arr.append((number, costs))
            total_cost += costs
        sorted_arr = sorted(tuple_arr, key=lambda tup: tup[0])
        curr_cost = 0
        result = 0
        for number, costs2 in sorted_arr:
            print(number, costs2)
            curr_cost += costs2
            if (curr_cost > total_cost//2):
                target = number
                result = self.cal_result(nums, cost, target)
                break
        return result
        
    def cal_result(self, nums, cost, target):
        total_cost = 0
        for i in range(0, len(nums)):
            number = nums[i]
            costs = cost[i]
            total_cost += abs(number - target) * costs
        return total_cost