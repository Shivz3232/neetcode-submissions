from functools import reduce

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        zeroCount = 0
        for num in nums:
            if num == 0:
                zeroCount += 1

        products = [0] * len(nums)

        if zeroCount > 1:
            return products
        
        products[0] = nums[0]
        i = 1

        products[1] = nums[-1]
        j = len(nums) - 2
        while i <= j:
            
            i += 1
            j -= 1
        

        
