class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> h = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : stones) h.add(i);

        while (h.size() > 1) {
            // display(h);
            int x = h.remove();
            int y = h.remove();

            int z = x - y;

            if (z > 0) h.add(z);
        }

        if (h.size() == 1) return h.peek();

        return 0;
    }

    public void display(Queue<Integer> h) {
        for (Integer i : h) System.out.print(i + ", ");
        System.out.println();
    }
}
