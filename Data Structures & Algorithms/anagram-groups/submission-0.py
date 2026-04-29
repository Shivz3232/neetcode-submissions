class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        obj = defaultdict(list)

        for s in strs:
            frequencies = [0] * 26
            for c in s:
                frequencies[ord(c) - ord('a')] += 1
            
            obj[tuple(frequencies)].append(s)
        
        return list(obj.values())