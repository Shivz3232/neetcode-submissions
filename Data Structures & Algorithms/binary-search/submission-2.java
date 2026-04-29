class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int startI = 0;
        int endI = nums.length - 1;
        int mid = findMiddle(startI, endI);

        // int c = 0;
        while (startI < endI) {
            // c += 1;
            // System.out.println(startI + ", " + mid + ", " + endI);

            if (nums[mid] < target) {
                startI = mid + 1;
                mid = findMiddle(startI, endI);
            } else if (nums[mid] == target) {
                return mid;
            } else {
                endI = mid - 1;
                mid = findMiddle(startI, endI);
            }
        }

        // System.out.println(startI + ", " + mid + ", " + endI);

        if (nums[mid] == target) {
            return mid;
        }

        return -1;
    }

    private int findMiddle(int startI, int endI) {
        int sum = endI + startI;
        if (sum % 2 == 0) {
            return (int) sum / 2;
        } else {
            return (int) (sum + 1) / 2;
        }
    }
}
