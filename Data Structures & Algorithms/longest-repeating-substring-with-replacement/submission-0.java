class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();

        int result = 0;

        int l = 0, r = 0;
        while (l < s.length()) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);

            if (r - l + 1 - maxFreq(freq) <= k) {
                if (r - l + 1 > result) {
                    result = r - l + 1;
                }

                if (r < s.length() - 1) {
                    r++;
                } else {
                    freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                    l++;    
                }
            } else {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }
        }

        return result;
    }

    private int maxFreq(HashMap<Character, Integer> freq) {
        int max = 0;
        for (char c : freq.keySet()) {
            if (freq.get(c) > max) {
                max = freq.get(c);
            }
        }

        return max;
    }
}
