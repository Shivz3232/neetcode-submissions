class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;

        int[] result = new int[n];

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0]) return -1;
            else if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return 1;
        });

        for (int i = 0; i < n; i++) {
            result[i] = searchA(0, intervals.length, queries[i], intervals);
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] < b[1]) return -1;
            else if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            else return 1;
        });

        for (int i = 0; i < n; i++) {
            result[i] = Math.min(
                result[i],
                searchB(0, intervals.length, queries[i], intervals)
            );
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }

        return result;
    }

    private int searchA(int l, int r, int q, int[][] intervals) {
        int result = Integer.MAX_VALUE;

        if (l == r) {
            return result;
        }

        int mid = (l + r) / 2;

        int[] i = intervals[mid];

        if (intervals[mid][0] <= q && q <= intervals[mid][1]) {
            result = intervals[mid][1] - intervals[mid][0] + 1;

            int lResult = searchA(l, mid, q, intervals);
            int rResult = searchA(mid + 1, r, q, intervals);

            result = Math.min(
                result,
                Math.min(lResult, rResult)
            );
        } else if (q < intervals[mid][0]) {
            result = searchA(l, mid, q, intervals);
        } else {
            result = searchA(mid + 1, r, q, intervals);
        }

        return result;
    }

    private int searchB(int l, int r, int q, int[][] intervals) {
        // if (q == 100) {
        //     System.out.printf("%d, %d", l, r);
        // }
        
        int result = Integer.MAX_VALUE;

        if (l == r) {
            return result;
        }

        int mid = (l + r) / 2;

        // if (q == 100) {
        //     System.out.printf(" | %d\n", mid);
        // }

        int[] i = intervals[mid];

        if (intervals[mid][0] <= q && q <= intervals[mid][1]) {
            result = intervals[mid][1] - intervals[mid][0] + 1;

            int lResult = searchB(l, mid, q, intervals);
            int rResult = searchB(mid + 1, r, q, intervals);

            result = Math.min(
                result,
                Math.min(lResult, rResult)
            );
        } else if (q < intervals[mid][1]) {
            result = searchB(l, mid, q, intervals);
        } else {
            result = searchB(mid + 1, r, q, intervals);
        }

        return result;
    }
}
