class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();

        int result = 0;

        int l = 0, r = 0;
        freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
        int maxFreq = 1;
        while (l < s.length()) {
            // System.out.println("l: " + l + " r: " + r);
            // printWindow(l, r, s);

            if (r - l + 1 - maxFreq <= k) {
                if (r - l + 1 > result) {
                    result = r - l + 1;
                }

                if (r < s.length() - 1) {
                    r++;
                    freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
                    if (freq.get(s.charAt(r)) > maxFreq) {
                        maxFreq = freq.get(s.charAt(r));
                    }
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

    // private int maxFreq(HashMap<Character, Integer> freq) {
    //     int max = 0;
    //     for (char c : freq.keySet()) {
    //         if (freq.get(c) > max) {
    //             max = freq.get(c);
    //         }
    //     }

    //     return max;
    // }

    private void printWindow(int l, int r, String s) {
        StringBuilder b = new StringBuilder();
        for (int i = l; i <= r; i++) {
            b.append(s.charAt(i));
        }
        System.out.println(b.toString());
    }
}
