class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int count = t.length();
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
        }

        int resultL = -1, resultR = -1;
        int l = 0, r = 0;
        while (r < s.length()) {
            if (count == 0) {
                if (r - l + 1 < resultR - resultL + 1) {
                    resultL = l;
                    resultR = r;
                }
            }

            // System.out.println("Count: " + count);
            // System.out.println("l: " + l + " r: " + r);
            // System.out.println(freq);
            // System.out.println();

            if (freq.containsKey(s.charAt(r))) {
                if (freq.get(s.charAt(r)) != 0) {
                    freq.put(s.charAt(r), freq.get(s.charAt(r)) - 1);
                    count--;
                }
            } else {
                if (count == 0) {
                    do {
                        if (freq.containsKey(s.charAt(l))) {
                            freq.put(s.charAt(l), freq.get(s.charAt(l)) + 1);
                        }
                        l++;
                    } while (l != r);
                    count = t.length();
                    l++;
                } else {
                    if (count == t.length()) {
                        l++;
                    }
                }
            }

            r++;
        }

        if (count == 0) {
            resultL = l;
            resultR = r;
        }

        if (resultL == -1 || resultR == -1) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = resultL; i < resultR; i++) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
