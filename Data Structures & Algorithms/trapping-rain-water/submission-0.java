class Solution {
    public int trap(int[] height) {
        int maxSoFar = 0;
        List<Integer> forwardPass = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= height[maxSoFar]) {
                maxSoFar = i;
            }
            
            forwardPass.add(height[maxSoFar] - height[i]);
        }

        // System.out.println(forwardPass);

        maxSoFar = height.length - 1;
        List<Integer> reversePass = new ArrayList<>();
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] >= height[maxSoFar]) {
                maxSoFar = i;
            }
            
            reversePass.add(height[maxSoFar] - height[i]);
        }
        Collections.reverse(reversePass);

        // System.out.println(reversePass);

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (forwardPass.get(i) > reversePass.get(i)) {
                result += reversePass.get(i);
            } else {
                result += forwardPass.get(i);
            }
        }

        return result;
    }
}
