class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int resultI = 0;
        int[] result = new int[nums.length - k + 1];

        PriorityQueue<Node> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int l = 0, r = 0;
        for (;r < k - 1; r++) {
            maxHeap.add(new Node(nums[r], r));
        }
        // result[resultI++] = maxHeap.peek().val();

        // r++;
        // l++;
        while (r < nums.length) {
            maxHeap.add(new Node(nums[r], r));
            while (maxHeap.peek().i() < l) {
                maxHeap.remove();
            }
            result[resultI++] = maxHeap.peek().val();

            // System.out.println("l: " + l + " r: " + r);
            // System.out.println(Arrays.asList(result));
            // System.out.println();

            r++;
            l++;
        }

        return result;
    }

    private class Node implements Comparable<Node> {
        private final int val;
        private final int i;

        public Node(int val, int i) { 
            this.val = val;
            this.i = i;
        }

        public int val() {
            return this.val;
        }

        public int i() {
            return this.i;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val(), o.val());
        }
    }
}
