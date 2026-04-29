class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> chars = new HashMap<>();
        chars.put(s.charAt(0), 0);
        int result = 1;
        int cur = result;
        for (int i = 1; i < s.length(); i++) {
            if (chars.containsKey(s.charAt(i))) {
                if (cur > result) {
                    result = cur;
                }

                List<Character> keys = new ArrayList(chars.keySet());
                int lowest = chars.get(s.charAt(i));
                for (Character key : keys) {
                    if (chars.get(key) <= lowest) {
                        chars.remove(key);
                        cur--;
                    }
                }

                chars.put(s.charAt(i), i);
                cur++;
            } else {
                chars.put(s.charAt(i), i);
                cur++;
            }
        }

        if (cur > result) {
            result = cur;
        }

        return result;
    }
}
