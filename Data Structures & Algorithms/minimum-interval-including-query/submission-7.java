class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0]) return -1;
            else if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return 1;
        });


        int[] result = new int[queries.length];


        // This is the trick to this question 
        // It avoids m * n. How?
        // Arrays.sort(queries);

        for (int i = 0; i < queries.length; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0] + 1, b[1] - b[0] + 1));
            
            int q = queries[i];
            
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] > q) break;

                pq.add(intervals[j]);
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.remove();
            }

            if (pq.isEmpty()) {
                result[i] = -1;
            } else {
                int[] top = pq.peek();

                result[i] = top[1] - top[0] + 1;
            }
        }

        return result;
    }
}
