class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0]) return -1;
            else if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return 1;
        });

        int n = queries.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int x = search(0, intervals.length, queries[i], intervals);

            if (x == Integer.MAX_VALUE) {
                result[i] = -1;
            } else {
                result[i] = x;
            }
        }

        return result;
    }

    private int search(int l, int r, int q, int[][] intervals) {
        if (l == r) {
            return Integer.MAX_VALUE;
        }

        int mid = (l + r) / 2;

        int result = -1;

        int[] i = intervals[mid];

        if (intervals[mid][0] <= q && q <= intervals[mid][1]) {
            result = intervals[mid][1] - intervals[mid][0] + 1;

            int lResult = search(l, mid, q, intervals);
            int rResult = search(mid + 1, r, q, intervals);

            result = Math.min(
                result,
                Math.min(lResult, rResult)
            );
        } else if (q < intervals[mid][0]) {
            result = search(l, mid, q, intervals);
        } else {
            result = search(mid + 1, r, q, intervals);
        }

        return result;
    }
}
