class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>(Comparator.reverseOrder());
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.isEmpty() && right.isEmpty()) left.offer(num);
        else if (!right.isEmpty()) {
            if (num >= right.peek()) right.offer(num);
            else left.offer(num);
        } else if (!left.isEmpty()) {
            if (num <= left.peek()) left.offer(num);
            else right.offer(num);
        } else {
            if (num >= right.peek()) right.offer(num);
            else left.offer(num);
        }

        int diff = right.size() - left.size();
        if (Math.abs(diff) > 1) {
            if (diff > 0) balance(right, left);
            else balance(left, right);
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
            return (double) left.peek();
        } else if (left.size() == right.size()) {
            return ((double) (left.peek() + right.peek())) / 2;
        } else {
            return (double) right.peek();
        }
    }

    private void balance(PriorityQueue<Integer> base, PriorityQueue<Integer> target) {
        int diff = Math.abs(base.size() - target.size());
        while (diff > 1 && !base.isEmpty()) {
            target.offer(base.poll());
            diff = Math.abs(base.size() - target.size());
        }
    }
}
