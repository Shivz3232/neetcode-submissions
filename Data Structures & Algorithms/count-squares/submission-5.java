class CountSquares {
    private final Map<Integer, Map<Integer, Integer>> X;
    private final Map<Integer, Map<Integer, Integer>> Y;

    public CountSquares() {
        this.X = new HashMap<>();
        this.Y = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        
        if (!this.X.containsKey(x)) {
            this.X.put(x, new HashMap<>());
        }

        Map<Integer, Integer> freq = this.X.get(x);
        if (freq.containsKey(y)) {
            freq.put(y, freq.get(y) + 1);
        } else {
            freq.put(y, 1);
        }

        if (!this.Y.containsKey(y)) {
            this.Y.put(y, new HashMap<>());
        }

        freq = this.Y.get(y);
        if (freq.containsKey(x)) {
            freq.put(x, freq.get(x) + 1);
        } else {
            freq.put(x, 1);
        }
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];

        if (!(this.X.containsKey(x1) && this.Y.containsKey(y1))) {
            return 0;
        }

        int result = 0;

        Map<Integer, Integer> k = X.get(x1);
        Map<Integer, Integer> l = Y.get(y1);
        
        int side, count;
        for (int y2 : k.keySet()) {
            // Skip point if same as source
            if (y2 == y1) continue;
            
            // Length of the side of the possible square
            side = Math.abs(y1 - y2);

            // Try forming a square by going to the right
            count = X.get(x1).get(y2);

            int x2 = x1 + side;

            if (l.containsKey(x2)) {
                count *= Y.get(y1).get(x2);

                // Check if the fourth point exists
                if (this.X.get(x2).containsKey(y2)) {
                    count *= X.get(x2).get(y2);

                    result += count;
                }
            }

            // Try forming a square by going to the left
            count = X.get(x1).get(y2);

            x2 = x1 - side;

            if (l.containsKey(x2)) {
                count *= Y.get(y1).get(x2);

                // Check if the fourth point exists
                if (this.X.get(x2).containsKey(y2)) {
                    count *= X.get(x2).get(y2);

                    result += count;
                }
            }
        }

        return result;
    }
}
