class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int pile : piles) {
            if (pile < min) {
                min = pile;
            }

            if (pile > max) {
                max = pile;
            }
        }

        System.out.println(max + ", " + min);

        int result = -1;
        for (int speed = min; speed <= max; speed++) {
            int time = 0;
            for (int pile : piles) {
                if (pile < speed) {
                    time += 1;
                } else if (pile % speed == 0) {
                    time += (int) pile / speed;
                } else {
                    time += ((int) pile / speed) + 1;
                }
            }

            System.out.println(speed + ", " + time + ", " + result);

            if (time <= h) {
                result = speed;
                break;
            }
        }

        return result == -1 ? max : result;
    }
}
