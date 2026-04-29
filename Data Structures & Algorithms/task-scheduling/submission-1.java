class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> f = new HashMap<>();
        for (char t : tasks) f.put(t, f.getOrDefault(t, 0) + 1);

        PriorityQueue<Task> h = new PriorityQueue<>(Comparator.reverseOrder());
        for (Character t : f.keySet()) {
            h.add(new Task(t, f.get(t)));
        }

        Queue<Task> q = new LinkedList<>();

        int time = 0;
        while (!h.isEmpty() || !q.isEmpty()) {
            time++;

            if (!h.isEmpty()) {
                Task ht = h.poll();
                ht.frequency--;

                if (ht.frequency > 0) {
                    ht.nextAvailability = time + n;
                    q.add(ht);
                }
            }

            while (!q.isEmpty() && q.peek().nextAvailability == time) {
                h.add(q.remove());
            }
        }

        return time;
    }

    private static class Task implements Comparable<Task> {
        public final char id;
        public int frequency;
        public int nextAvailability;

        public Task(char id, int frequency) {
            this.id = id;
            this.frequency = frequency;
            this.nextAvailability = 0;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(this.frequency, o.frequency);
        }
    }
}
