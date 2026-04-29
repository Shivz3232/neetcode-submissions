class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }

        throw new IllegalStateException();

        // for (int i = 0; i < numbers.length - 1; i++) {
        //     for (int j = 0; j < numbers.length; j++) {
        //         if (numbers[i] + numbers[j] == target) {
        //             return new int[] {
        //                 numbers[i],
        //                 numbers[j]
        //             };
        //         }
        //     }
        // }

        // throw new IllegalStateException("No solution found");
    }
}
