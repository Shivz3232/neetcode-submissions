from functools import reduce

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        zeroCount = 0
        zeroI = -1
        for i in range(len(nums)):
            if nums[i] == 0:
                zeroCount += 1
                zeroI = i

        result = [0] * len(nums)

        if zeroCount > 1:
            return result
        
        prefix = [0] * len(nums)
        prev = 1
        i = 0
        while i < len(nums):
            prefix[i] = prev
            if nums[i] != 0:
                prev *= nums[i]
            i += 1
        
        suffix = [0] * len(nums)
        prev = 1
        j = len(nums) - 1
        while j >= 0:
            suffix[j] = prev
            if nums[j] != 0:
                prev *= nums[j]
            j -= 1

        if zeroCount == 1:
            result[zeroI] = prefix[zeroI] * suffix[zeroI]
            return result
        
        print(prefix)
        print(suffix)
        
        i = 0
        while i < len(nums):
            result[i] = prefix[i] * suffix[i]
            i += 1

        return result
        
