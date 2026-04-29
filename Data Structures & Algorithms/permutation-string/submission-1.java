class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> masterFreq = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            masterFreq.put(s1.charAt(i), masterFreq.getOrDefault(s1.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> freq = copyMap(masterFreq);

        int l = 0, r = 0, seen = 0;

        if (freq.containsKey(s2.charAt(r))) {
            seen = 1;
            freq.put(s2.charAt(r), freq.get(s2.charAt(r)) - 1);
            r++;
        }

        while (r < s2.length()) {
            if (seen == s1.length()) {
                return true;
            }

            if (freq.containsKey(s2.charAt(r)) && freq.get(s2.charAt(r)) != 0) {
                freq.put(s2.charAt(r), freq.get(s2.charAt(r)) - 1);
                seen++;
            } else {
                freq = copyMap(masterFreq);
                seen = 0;
                l = r;
            }

            r++;
        }

        return false;
    }

    private HashMap<Character, Integer> copyMap(HashMap<Character, Integer> source) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (Character c : source.keySet()) {
            result.put(c, source.get(c));
        }

        return result;
    }
}
