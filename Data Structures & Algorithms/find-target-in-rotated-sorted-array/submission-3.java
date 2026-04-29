class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        int mid = findMiddle(left, right);
        while (left < right) {
            System.out.println(left + ", " + mid + ", " + right);

            if (target < nums[mid]) {
                if (target == nums[left]) {
                    return left;
                } else {
                    right = mid - 1;
                }
            } else if (target == nums[mid]) {
                return mid;
            } else {
                if (target < nums[right]) {
                    left = mid + 1;
                } else if (target == nums[right]) {
                    return right;
                } else {
                    right = mid - 1;
                }
            }

            mid = findMiddle(left, right);
        }

        if (left < length && nums[left] == target) {
            return left;
        }

        return -1;
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
