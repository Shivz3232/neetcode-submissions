class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<StackElement> stack = new Stack<>();
        
        int result = 0;
        StackElement old;
        for (int i = 0; i < heights.length; i++) {
            // System.out.println(i + ", " + result);
            // displayStack(stack);
            // System.out.println();

            if (stack.isEmpty()) {
                stack.push(new StackElement(heights[i], i));
                continue;
            }

            StackElement n = new StackElement(heights[i], i);
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                old = stack.pop();

                if (old.height * (i - old.index) > result) {
                    result = old.height * (i - old.index());
                }

                n.setIndex(old.index());
            }

            stack.push(n);
        }

        while (!stack.isEmpty()) {
            // System.out.println(result);
            // displayStack(stack);
            // System.out.println();

            old = stack.pop();

            if (old.height * (heights.length - old.index) > result) {
                result = old.height * (heights.length - old.index);
            }
        }

        return result;
    }

    private class StackElement {
        public final int height;
        private int index;

        public StackElement(int height, int index) {
            this.height = height;
            this.index = index;
        }

        public void setIndex(int i) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }

            this.index = i;
        }

        public int index() {
            return this.index;
        }
    }

    private void displayStack(Stack<StackElement> stack) {
        for (StackElement e : stack) {
            System.out.print(e.height + "," + e.index() + " | ");
        }

        System.out.println();
    }
}
