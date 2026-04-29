class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        result = [-1] * k

        frequencies = {}
        for i in nums:
            frequencies[i] = 1 + frequencies.get(i, 0)

        i = 0
        n = 0
        greatest = 0
        for key in frequencies:
            if frequencies[key] > greatest:
                result[i] = key
                i = (i + 1) % k
        
        print(result)

        return result
