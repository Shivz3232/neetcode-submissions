class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>(Comparator.reverseOrder());
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        right.offer(num);

        while (left.size() < right.size() - 1) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return ((double) (left.peek() + right.peek())) / 2;
        } else {
            return (double) right.peek();
        }
    }
}
