class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>(Comparator.reverseOrder());
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.isEmpty() && right.isEmpty()) {
            left.offer(num);
        } else if (right.isEmpty()) {
            if (num < left.peek()) left.offer(num);
            else right.offer(num);
        } else if (left.isEmpty()) {
            if (num > right.peek()) right.offer(num);
            else left.offer(num);
        } else if (num < left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        for (int x : left) System.out.println(x);
        // System.out.println("right");
        for (int x : right) System.out.println(x);
        // System.out.println();

        while (right.size() > left.size()) left.offer(right.poll());
        while (left.size() > right.size()) right.offer(left.poll());
    }
    
    public double findMedian() {
        // return 0;
        if (left.size() == right.size()) {
            return ((double) (left.peek() + right.peek())) / 2;
        } else {
            return (double) left.peek();
        }
    }
}
