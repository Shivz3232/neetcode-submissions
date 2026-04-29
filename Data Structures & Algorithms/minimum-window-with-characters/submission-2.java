class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.equals("")) {
            return "";
        }

        int count = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int resultL = -1, resultR = -1;
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (freq.containsKey(c) && window.get(c) <= freq.get(c)) {
                count++;
            }

            // System.out.println(window);
            // System.out.println(count);
            // System.out.println("r: " + r + " l: " + l);
            // System.out.println("resultR: " + resultR + " resultL: " + resultL);
            // System.out.println();

            while (count == t.length()) {
                if (resultR == -1 || (r - l + 1) < (resultR - resultL + 1)) {
                    resultL = l;
                    resultR = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if (freq.containsKey(leftChar) && window.get(leftChar) < freq.get(leftChar)) {
                    count--;
                }

                l++;
            }

            r++;
        }

        // System.out.println("resultL: " + resultL + " resultR: " + resultR);

        if (resultL == -1 || resultR == -1) {
            return "";
        }

        return s.substring(resultL, resultR + 1);
    }

    private boolean negativesPresent(HashMap<Character, Integer> freq) {
        for (char c : freq.keySet()) {
            if (freq.get(c) < 0) {
                return true;
            }
        }

        return false;
    }
}
