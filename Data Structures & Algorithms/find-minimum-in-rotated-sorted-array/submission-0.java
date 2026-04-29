class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;
        int mid;

        while (nums[left] > nums[right]) {
            mid = findMiddle(left, right);

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                left = mid - 1;
            }
        }

        return nums[left];
    }

    private int findMiddle(int left, int right) {
        int sum = left + right;
        if (sum % 2 == 0) {
            return (int) sum / 2;
        } else {
            return (int) (sum + 1) / 2;
        }
    }
}
