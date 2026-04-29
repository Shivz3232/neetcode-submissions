class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequencies = {}
        for i in nums:
            frequencies[i] = 1 + frequencies.get(i, 0)
        
        results = []
        for f in frequencies:
            if frequencies[f] >= k:
                results.append(f)

        return results
