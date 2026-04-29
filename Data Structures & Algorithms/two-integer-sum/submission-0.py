class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        obj = {}

        i = 0
        while i < len(nums):
            if target - nums[i] in obj:
                return [obj[target - nums[i]], i]
            else:
                obj[nums[i]] = i

            i += 1
        
        raise "error"