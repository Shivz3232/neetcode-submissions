class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0]) return -1;
            else if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return 1;
        });

        int[] result = new int[queries.length];

        Query[] customQueries = new Query[queries.length];

        for (int i = 0; i < queries.length; i++) {
            customQueries[i] = new Query(queries[i], i);
        }

        Arrays.sort(customQueries);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0] + 1, b[1] - b[0] + 1));

        // This is the trick to this question 
        // It avoids m * n.
        // How? It avoids re-checking seen smaller intervals for larger queries
        Arrays.sort(customQueries);

        int j = 0;
        for (Query q : customQueries) {
            for (; j < intervals.length; j++) {
                if (intervals[j][0] > q.q) break;

                pq.add(intervals[j]);
            }

            while (!pq.isEmpty() && pq.peek()[1] < q.q) {
                pq.remove();
            }

            if (pq.isEmpty()) {
                result[q.i] = -1;
            } else {
                int[] top = pq.peek();

                result[q.i] = top[1] - top[0] + 1;
            }
        }

        return result;
    }

    private class Query implements Comparable<Query> {
        public final int q;
        public final int i;

        Query(int q, int i) {
            this.q = q;
            this.i = i;
        }

        @Override
        public int compareTo(Query o) {
            return Integer.compare(this.q, o.q);
        }
    }
}
