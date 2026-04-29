class Solution {
    public int findDuplicate(int[] nums) {
        int length = nums.length;

        BitSet map = new BitSet(length);

        for (int n : nums) {
            if (map.get(n)) {
                return n;
            }

            map.set(n);
        }

        return -1;
    }
}
