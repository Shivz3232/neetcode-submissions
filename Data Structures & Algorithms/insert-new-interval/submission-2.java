class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        
        int i1 = intervals.length + 1;
        boolean o1 = false;
        for (int i = intervals.length - 1; i >= 0; i--) {
            if (intervals[i][1] < newInterval[0]) {
                i1 = i + 1;
                break;
            } else if (intervals[i][0] <= newInterval[0]) {
                i1 = i;
                o1 = true;
                break;
            }

            i1 = i;
        }

        int i2 = -1;
        boolean o2 = false;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                i2 = i;
                break;
            } else if (newInterval[1] <= intervals[i][1]) {
                i2 = i;
                o2 = true;
                break;
            }

            i2 = i;
        }

        System.out.println("i1: " + i1 + ", o1: " + o1);
        System.out.println("i2: " + i2 + ", o2: " + o2);

        // return new int[][]{};
        
        for (int i = 0; i < i1; i++) {
            result.add(List.of(intervals[i][0], intervals[i][1]));
        }

        if (o1) {
            result.add(new ArrayList<>());
            result.get(result.size() - 1).add(intervals[i1][0]);
        } else {
            result.add(new ArrayList<>());
            result.get(result.size() - 1).add(newInterval[0]);
        }

        if (o2) {
            result.get(i1).add(intervals[i2][1]);
        } else {
            result.get(i1).add(newInterval[1]);
        }

        for (int i = o2 ? i2 + 1 : o1 ? i1 + 1 : i1; i < intervals.length; i++) {
            result.add(List.of(intervals[i][0], intervals[i][1]));
        }

        int[][] r = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            r[i][0] = result.get(i).get(0);
            r[i][1] = result.get(i).get(1);
        }

        return r;
    }
}
