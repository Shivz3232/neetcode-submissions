class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();

        s.add(n);

        return isHappy(digitSum(n), s, 0);
    }

    private boolean isHappy(int i, Set<Integer> s, int k) {
        // if (k > 20) return false;
        if (i == 1) return true;
        if (s.contains(i)) return false;

        s.add(i);

        return isHappy(digitSum(i), s, k + 1);
    }

    private int digitSum(int i) {
        int result = 0;

        while (i > 0) {
            result += Math.pow(i % 10, 2);

            i /= 10;
        }

        // System.out.println(result);

        return result;
    }
}
