class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> h = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            h.add(new Point(points[i][0], points[i][1]));
        }

        int[][] result = new int[k][2];
        
        for (int i = 0; i < k; i++) {
            Point p = h.remove();

            result[i][0] = p.x;
            result[i][1] = p.y;
        }

        return result;
    }

    private static class Point implements Comparable<Point> {
        public final int x;
        public final int y;
        public final double distanceToOrigin;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distanceToOrigin = Math.sqrt(
                Math.pow(x, 2) + Math.pow(y, 2)
            );
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(distanceToOrigin, o.distanceToOrigin);
        }
    }
}
