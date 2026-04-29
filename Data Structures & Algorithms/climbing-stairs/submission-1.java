class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int x = 1;
        int y = 2;
        int result = 3;
        
        for (int i = 3; i <= n; i++) {
            result = x + y;
            x = y;
            y = result;
        }

        return result;
    }
}
