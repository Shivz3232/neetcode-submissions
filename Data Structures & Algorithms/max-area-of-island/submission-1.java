class DSU {
    private final int[] parent, size;

    DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 1; i <= n; i++) size[i] = 1;
    }

    public int findParent(int i) {
        if (i != parent[i]) {
            // This step flattens the tree.
            parent[i] = findParent(parent[i]);
        }

        return parent[i];
    }

    public int getSize(int i) {
        return size[findParent(i)];
    }

    public boolean union(int i, int j) {
        int parentI = findParent(i);
        int parentJ = findParent(j);

        if (parentI == parentJ) return false;

        if (size[parentI] >= size[parentJ]) {
            size[parentI] += size[parentJ];
            parent[parentJ] = parentI;
        } else {
            size[parentJ] += size[parentI];
            parent[parentI] = parentJ;
        }

        return true;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        DSU disjointSetUnion = new DSU(rows * cols);

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) continue;

                int index = i * cols + j;

                for (int[] direction : directions) {
                    int m = i + direction[0];
                    int n = j + direction[1];

                    if (m < 0 || m >= rows || n < 0 || n >= cols) continue;

                    if (grid[m][n] == 0) continue;

                    disjointSetUnion.union(
                        m * cols + n,
                        index
                    );
                }

                if (disjointSetUnion.getSize(index) > result) {
                    result = disjointSetUnion.getSize(index);
                }
            }
        }

        return result;
    }
}
