class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int n = matrix.length;
        int m = matrix[0].length;

        // [i, j, stage, numRowsSeen, numColsSeen]
        int[] state = new int[5];
        for (int k = 0; k < n * m; k++) {
            result.add(matrix[state[0]][state[1]]);

            updateState(state, n, m);
        }

        return result;
    }

    private void updateState(int[] state, int n, int m) {
        switch(state[2]) {
            case 0:
                if (state[1] == m - state[4] - 1) {
                    state[0]++;
                    state[2]++;
                    state[3]++;
                } else {
                    state[1]++;
                }

                break;
            case 1:
                if (state[0] == n - state[3]) {
                    state[1]--;
                    state[2]++;
                    state[4]++;
                } else {
                    state[0]++;
                }

                break;
            case 2:
                if (state[1] == state[4] - 1) {
                    state[0]--;
                    state[2]++;
                } else {
                    state[1]--;
                }

                break;
            case 3:
                if (state[0] == state[3]) {
                    state[1]++;
                    state[2] = 0;
                } else {
                    state[0]--;
                }

                break;
            default:
                throw new IllegalArgumentException("Invalid stage");
        }
    }
}
