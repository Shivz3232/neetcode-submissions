class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        result.get(result.size() - 1).add(intervals[0][0]);

        boolean open = false;
        int e = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (e < intervals[i][0]) {
                result.get(result.size() - 1).add(e);

                result.add(new ArrayList<>());
                result.get(result.size() - 1).add(intervals[i][0]);

                e = intervals[i][1];
            } else if (e < intervals[i][1]) {
                e = intervals[i][1];
            }
        }

        result.get(result.size() - 1).add(e);

        int[][] r = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            r[i][0] = result.get(i).get(0);
            r[i][1] = result.get(i).get(1);
        }

        return r;
    }
}
