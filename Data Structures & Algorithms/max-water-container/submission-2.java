class Solution {
    public int maxArea(int[] heights) {
        int largest = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[largest]) {
                largest = i;
            }
        }
        
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i == largest) continue;

            if (i > largest) {
                if ((heights[i] * (i - largest)) > result) {
                    result = heights[i] * (i - largest);
                }
            } else {
                if ((heights[i] * (largest - i)) > result) {
                    result = heights[i] * (largest - i);
                }
            }
        }

        return result;
    }
}
