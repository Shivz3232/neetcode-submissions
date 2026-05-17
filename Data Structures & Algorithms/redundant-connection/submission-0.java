class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Set<Integer>> sets = new HashMap<>();
        int nSets = 0;

        for (int[] edge : edges) {
            // displaySets(sets);
            // System.out.println();
            
            int s1 = findSet(sets, edge[0]);
            int s2 = findSet(sets, edge[1]);

            if (s1 == -1 && s2 == -1) {
                sets.put(++nSets, new HashSet<>(){
                    {
                        add(edge[0]);
                        add(edge[1]);
                    }
                });
            } else if (s1 == -1) {
                sets.get(s2).add(edge[0]);
            } else if (s2 == -1) {
                sets.get(s1).add(edge[1]);
            } else if (s2 == s1) {
                return edge;
            } else {
                merge(s1, s2, sets);
            }
        }

        throw new IllegalArgumentException();
    }

    private int findSet(HashMap<Integer, Set<Integer>> sets, int i) {
        for (int key : sets.keySet()) {
            if (sets.get(key).contains(i)) {
                return key;
            }
        }

        return -1;
    }

    private void merge(int s1, int s2, HashMap<Integer, Set<Integer>> sets) {
        Set<Integer> set2 = sets.get(s2);

        sets.remove(s2);

        sets.get(s1).addAll(set2);
    }

    private void displaySets(HashMap<Integer, Set<Integer>> sets) {
        for (int key : sets.keySet()) {
            System.out.print(key + ": ");
            for (int v : sets.get(key)) {
                System.out.print(v + ", ");
            }
            System.out.println();
        }
    }
}
