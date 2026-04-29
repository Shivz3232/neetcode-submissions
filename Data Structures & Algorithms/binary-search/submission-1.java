class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int startI = 0;
        int endI = nums.length - 1;
        int mid = findMiddle(startI, endI);

        while (startI <= mid && mid <= endI) {
            if (nums[mid] < target) {
                startI = mid;
                mid = findMiddle(startI, endI);
            } else if (nums[mid] == target) {
                return mid;
            } else {
                endI = mid;
                mid = findMiddle(startI, endI);
            }
        }

        return -1;
    }

    private int findMiddle(int startI, int endI) {
        int n = findLength(startI, endI);

        if (n % 2 == 0) {
            return ((int) n / 2);
        } else {
            return (int) (n + 1) / 2;
        }
    }

    private int findLength(int startI, int endI) {
        return endI - startI + 1;
    }
}
