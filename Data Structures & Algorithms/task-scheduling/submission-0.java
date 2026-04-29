class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> m = new HashMap<>();
        for (char t : tasks) m.put(t, -1);

        Queue<Character> q = new LinkedList<>();
        for (char t : tasks) q.add(t);

        int time = 0;
        while (!q.isEmpty()) {
            boolean found = false;
            Character top = q.peek();
            int lastExecuted = m.get(top);
            for (int i = 0; i < q.size(); i++) {
                if (lastExecuted == -1 || time - lastExecuted >= n) {
                    found = true;
                    break;
                }

                q.remove();
                q.add(top);

                top = q.peek();
                lastExecuted = m.get(top);
            }

            time++;

            // System.out.println(m);
            if (found) {
                // System.out.println("At " + time + ", executing " + top);
                m.put(top, time);
                q.remove();
            } else {
                // System.out.println("At " + time + ", idling");
            }
        }

        return time;
    }
}
