class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalEle = nums1.lenght + nums2.length;
        int partitionSize = (int) total / 2;

        int[] curSearchTarget;
        int[] other;
        if (nums1.length < nums2.length) {
            curSearchTarget = nums1;
            other = nums2;
        } else {
            other = nums1;
            curSearchTarget = nums2;
        }

        int left = 0;
        int right = curSearchTarget.length - 1;
        int mid = findMiddle(left, right);

        while(!validPartition(curSearchTarget, mid, other)) {

        }
    }

    private int findMiddle(int left, int right) {
        int sum = left + right;
        if (sum == 0) {
            return -1;
        }
        
        return (int) sum / 2;
    }

    private boolean validPartition(int[] curSearchTarget, int mid, int[] other) {
        int totalEle = curSearchTarget.length + other.length;
        int partitionSize = totalEle / 2;
        int otherMid = partitionSize - (mid + 1) - 1;

        if (curSearchTarget.length != 0) {
            if (mid < curSearchTarget.length - 1) {

            } else {}
        }
    }
}
