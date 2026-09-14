class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return 1;
            }
        });

        int result = 0;

        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                prevEnd = Math.min(prevEnd, intervals[i][1]);

                result += 1;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        
        return result;
    }
}
