class CountSquares {
    private final Map<Integer, List<Integer>> x;
    private final Map<Integer, List<Integer>> y;

    public CountSquares() {
        this.x = new HashMap<>();
        this.y = new HashMap<>();
    }
    
    public void add(int[] point) {
        if (!this.x.containsKey(point[0])) {
            this.x.put(point[0], new ArrayList<>());
        }

        sortedInsert(this.x.get(point[0]), point[1]);

        if (!this.y.containsKey(point[1])) {
            this.y.put(point[1], new ArrayList<>());
        }

        sortedInsert(this.y.get(point[1]), point[0]);
    }
    
    public int count(int[] point) {
        int a = point[0];
        int b = point[1];

        if (!(this.x.containsKey(a) && this.y.containsKey(b))) {
            return 0;
        }

        int result = 0;

        List<Integer> k = this.x.get(a); // [2]
        List<Integer> l = this.y.get(b); // [1]
        
        int s, sAbs;
        for (int i = 0; i < k.size(); i++) {            
            // Length of the side of the possible square
            s = k.get(i) - b; // 1
            sAbs = Math.abs(s);

            // Try forming a square by going to the right
            int p = search(a + sAbs, l); // 0
            if (p != -1) {
                int u = l.get(p);

                // Check if the fourth point exists
                // by going in the same direction as s
                List<Integer> w = this.x.get(u);
                int q = search(u + s, w);

                int count1 = 0;
                if (q != -1) {
                    for (int n = q; n < w.size() && w.get(n) == u + s; n++) {
                        count1++;
                    }
                }

                int count2 = 0;
                if (count1 != 0) {
                    for (int n = p; n < l.size() && l.get(n) == a - sAbs; n++) {
                        count2++;
                    }
                }

                result += count1 * count2;
            }

            // Try forming a square by going to the left
            p = search(a - sAbs, l);
            if (p != -1) {
                int u = l.get(p);

                // Check if the fourth point exists
                // by going in the same direction as s
                List<Integer> w = this.x.get(u);
                int q = search(u + s, w);

                int count1 = 0;
                if (q != -1) {
                    for (int n = q; n < w.size() && w.get(n) == u + s; n++) {
                        count1++;
                    }
                }

                int count2 = 0;
                if (q != -1 && count1 != 0) {
                    for (int n = p; n < l.size() && l.get(n) == a - sAbs; n++) {
                        count2++;
                    }
                }

                result += count1 * count2;
            }
        }

        // TODO: If there are exactly similar points add them to the total count

        return result;
    }

    private int search(int x, List<Integer> l) {
        return searchAux(x, l, 0, l.size());
    }

    private int searchAux(int x, List<Integer> l, int left, int right) {
        if (left >= right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (l.get(mid) < x) {
            return searchAux(x, l, left, mid);
        } else if (l.get(mid) == x) {
            return mid;
        } else {
            return searchAux(x, l, mid + 1, right);
        }
    }

    private void sortedInsert(List<Integer> l, int x) {
        int i = 0;
        for (; i < l.size() && l.get(i) <= x; i++);

        l.add(i, x);
    }
}
