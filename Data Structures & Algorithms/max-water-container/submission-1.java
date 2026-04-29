class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        
        for (int i = 0; i < heights.length; i++) {
            int j = heights.length - 1;
            while (j > i) {
                if (heights[i] < heights[j]) {
                    if (heights[i] * (j - i) > result) {
                        result = heights[i] * (j - i);
                    }
                } else {
                    if (heights[j] * (j - i) > result) {
                        result = heights[j] * (j - i);
                    }
                }

                j--;
            }
        }

        return result;
    }
}
