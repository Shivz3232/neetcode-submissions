class Solution {
    public boolean isHappy(int n) {
        return isHappy(digitSum(n), n);
    }

    private boolean isHappy(int i, int n) {
        if (i == 1) return true;
        if (i == n) return false;

        return isHappy(digitSum(i), i);
    }

    private int digitSum(int i) {
        int result = 0;

        while (i > 0) {
            result += i % 10;

            i /= 10;
        }

        return result;
    }
}
