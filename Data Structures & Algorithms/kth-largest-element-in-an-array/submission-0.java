class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> h = new PriorityQueue<>();

        int i;
        for (i = 0; i < k; i++) h.add(nums[k]);

        for (; i < nums.length; i++) {
            if (nums[i] <= h.peek()) continue;

            h.remove();
            h.add(nums[i]);
        }

        return h.peek();
    }
}
