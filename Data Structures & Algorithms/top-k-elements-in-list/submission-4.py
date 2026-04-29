class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequencies = {}
        for i in nums:
            frequencies[i] = 1 + frequencies.get(i, 0)

        frequencyBuckets = []
        for i in nums:
            frequencyBuckets.append([])
        
        for key in frequencies:
            frequencyBuckets[frequencies[key] - 1].append(key)
        
        print(frequencyBuckets)

        result = []
        i = len(nums) - 1
        collected = 0
        while i >= 0 and collected < k:
            for v in frequencyBuckets[i]:
                result.append(v)
                collected += 1
                if collected == k:
                    break
            
            i -= 1

        return result
