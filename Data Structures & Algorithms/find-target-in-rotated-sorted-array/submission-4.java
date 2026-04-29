class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        int mid = findMiddle(left, right);
        while (nums[left] > nums[right]) {
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                left = mid;
            } else {
                right = mid;
            }

            mid = findMiddle(left, right);
        }

        int cut = left;

        // System.out.println(cut);

        if (target >= nums[cut] && target <= nums[length - 1]) {
            left = cut;
            right = length - 1;
        } else if (target <= nums[cut] && target >= nums[0]) {
            right = cut;
            left = 0;
        } else {
            return -1;
        }

        // System.out.println(left + ", " + right);

        mid = findMiddle(left, right);
        while (left < right) {
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                return mid;
            } else {
                left = mid + 1;
            }

            mid = findMiddle(left, right);
        }

        if (target == nums[mid]) {
            return mid;
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
