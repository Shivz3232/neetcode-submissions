
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        totalProduct = reduce(lambda x, y: x * y, nums)

        result = []
        for num in nums:
            result.append(totalProduct / num)

        return result
