class KthLargest {
    private final int k;
    private final Queue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();

        for (int i = 0; i < nums.length && i < k; i++) {
            heap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if (heap.size() < k) {
            heap.add(val);
            return heap.peek();
        }

        if (val > heap.peek()) {
            heap.remove();
            heap.add(val);
        }

        return heap.peek();
    }
}
