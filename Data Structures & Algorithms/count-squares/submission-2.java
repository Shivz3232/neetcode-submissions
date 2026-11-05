class CountSquares {
    private final Map<Integer, List<Integer>> X;
    private final Map<Integer, Map<Integer, Integer> XFreq;
    private final Map<Integer, List<Integer>> Y;
    private final Map<Integer, Map<Integer, Integer> YFreq;

    public CountSquares() {
        this.X = new HashMap<>();
        this.XFreq = new HashMap<>();

        this.Y = new HashMap<>();
        this.XFreq = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        
        if (!this.X.containsKey(x)) {
            this.X.put(x, new ArrayList<>());
            this.XFreq.put(x, new HashMap<>());
        }

        HashMap<Integer, Integer> freq = this.XFreq.get(x);
        if (freq.containsKey(y)) {
            freq.put(y, freq.get(y) + 1);
        } else {
            freq.put(y, 1);
            sortedInsert(this.X.get(x), point[1]);
        }

        freq = this.YFreq.get(y);
        if (freq.containsKey(x)) {
            freq.put(x, freq.get(x) + 1);
        } else {
            freq.put(x, 1);
            sortedInsert(this.Y.get(point[1]), x);
        }
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];

        // System.out.printf("\nSource (%d, %d)\n", x1, y1);

        if (!(this.X.containsKey(x1) && this.Y.containsKey(y1))) {
            return 0;
        }

        int result = 0;

        List<Integer> k = X.get(x1);
        List<Integer> l = Y.get(y1);
        
        int count;
        int s, sAbs;
        for (int i = 0; i < k.size(); i++) {
            int y2 = k.get(i);

            count = XFreq.get(x1).get(y2);
            
            // System.out.printf("Forming square with (%d, %d)\n", x1, y2);
            
            // Length of the side of the possible square
            s = y2 - y1;
            sAbs = Math.abs(y1 - y2);

            // Try forming x1 square by going to the right
            int x2 = x1 + sAbs;
            int p = search(x2, l); // 0
            if (p != -1) {
                count *= YFreq.get(y1).get(x2);

                // System.out.printf("\nFound right (%d, %d)\n", x2, y1);

                // Check if the fourth point eXists
                // by going in the same direction as s
                List<Integer> w = this.X.get(x2);

                int q = search(y2, w);

                if (q != -1) {
                    count *= XFreq.get(x2).get(y2);

                    // System.out.printf("Count1: %d, count2: %d\n", count1, count2);

                    result += count;
                }
            }


            // Try forming x1 square by going to the left
            x2 = x1 - sAbs;

            // System.out.printf("\nTrying going left...\n");

            p = search(x2, l);
            if (p != -1) {
                // System.out.printf("Found left (%d, %d)\n", x2, y1);

                // Check if the fourth point exists
                // by going in the same direction as s
                List<Integer> w = this.X.get(x2);

                int q = search(y2, w);

                if (q != -1) {
                    // System.out.printf("Found fourth (%d, %d)\n", x2, y2);
                    
                    int count1 = 0;
                    for (int n = q; n < w.size() && w.get(n) == y2; n++) {
                        count1++;
                    }

                    int count2 = 0;
                    for (int n = p; n < l.size() && l.get(n) == x2; n++) {
                        count2++;
                    }

                    // System.out.printf("Count1: %d, count2: %d\n", count1, count2);

                    result += count1 * count2;
                }
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

        if (x < l.get(mid)) {
            return searchAux(x, l, left, mid);
        } else if (x == l.get(mid)) {
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
