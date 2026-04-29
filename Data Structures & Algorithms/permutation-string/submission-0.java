class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            freq.put(s1.charAt(i), freq.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int l = 0, r = 0, seen = 0;
        
        while (l < s2.length()) {

        }

        return false;
    }
}
