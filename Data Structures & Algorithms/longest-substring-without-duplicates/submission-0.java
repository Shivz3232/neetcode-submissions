class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashSet<Character> chars = new HashSet<>();
        chars.add(s.charAt(0));
        int result = 1;
        int cur = result;
        for (int i = 1; i < s.length(); i++) {
            if (chars.contains(s.charAt(i))) {
                if (cur > result) {
                    result = cur;
                }

                chars.clear();
                chars.add(s.charAt(i));
                cur = 1;
            } else {
                chars.add(s.charAt(i));
                cur++;
            }
        }

        if (cur > result) {
            result = cur;
        }

        return result;
    }
}
