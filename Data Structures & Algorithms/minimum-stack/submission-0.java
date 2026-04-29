class MinStack {
    private final Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) min = val;
        }
    }
    
    public void pop() {
        long pop = stack.pop();
        min = min - pop;
    }
    
    public int top() {
        long peek = stack.peek();
        if (peek > 0) {
            return (int) (min + peek);
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
