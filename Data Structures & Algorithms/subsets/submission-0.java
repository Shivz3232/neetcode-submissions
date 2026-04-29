class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // result.add(List.of());

        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            String s = Integer.toBinaryString(i);
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') l.add(nums[j + nums.length - s.length()]);
            }
            result.add(l);
        }

        return result;
    }
}
