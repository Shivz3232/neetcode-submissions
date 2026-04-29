class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            freq.put(s1.charAt(i), freq.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int l = 0, r = 0, seen = 0;
        while (r < s2.length()) {
            if (seen == s1.length()) {
                return true;
            }

            if (freq.containsKey(s2.charAt(r))) {
                if (freq.get(s2.charAt(r)) == 0) {
                    while (freq.get(s2.charAt(r)) == 0) {
                        freq.put(s2.charAt(l), freq.get(s2.charAt(l)) + 1);
                        l++;
                        seen--;
                    }
                }

                freq.put(s2.charAt(r), freq.get(s2.charAt(r)) - 1);
                seen++;
            } else {
                if (seen != 0) {
                    do {
                        freq.put(s2.charAt(l), freq.get(s2.charAt(l)) + 1);
                        l++;
                    } while (l != r);

                    seen = 0;
                } else {
                    l = r;
                }

                l++;
            }

            r++;
        }

        return seen == s1.length();
    }
}
