/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(Integer.MAX_VALUE);

        int result = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval ivl = intervals.get(i);

            if (ivl.start < pq.peek()) {
                result += 1;
            } else {
                pq.remove();
            }

            pq.add(ivl.end);
        }

        return result;
    }
}
