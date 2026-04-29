class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int min = Integer.MAX_VALUE;
        int max = 0;

        for (int pile : piles) {
            // if (pile < min) {
            //     min = pile;
            // }

            if (pile > max) {
                max = pile;
            }
        }

        int left = 1;
        int right = max;
        int mid = findMiddle(left, right);
        
        int result = mid;
        // int c = 0;
        while (left < right) {
            // c++;
            int viableSpeed = checkViability(mid, piles, h);

            if (viableSpeed <= 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = findMiddle(left, right);
        }

        if (left == right && left >= 1 && left <= max) {
            if (checkViability(mid, piles, h) <= 0) {
                result = mid;
            }
        }

        return result;
    }

    private int findMiddle(int left, int right) {
        int sum = left + right;
        if (sum % 2 == 0) {
            return (int) sum / 2;
        } else {
            return (int) (sum + 1) / 2;
        }
    }

    private int checkViability(int speed, int[] piles, int h) {
        int time = 0;
        for (int pile : piles) {
            if (pile < speed) {
                time++;
            } else if (pile % speed == 0) {
                time += (int) pile / speed;
            } else {
                time += ((int) pile / speed) + 1;
            }

            if (time > h) {
                return 1;
            }
        }

        if (time == h) {
            return 0;
        } else {
            return -1;
        }
    }

    // public int minEatingSpeed(int[] piles, int h) {
    //     int min = Integer.MAX_VALUE;
    //     int max = 0;
    //     for (int pile : piles) {
    //         if (pile < min) {
    //             min = pile;
    //         }

    //         if (pile > max) {
    //             max = pile;
    //         }
    //     }

    //     System.out.println(max + ", " + min);

    //     int result = -1;
    //     for (int speed = min; speed <= max; speed++) {
    //         int time = 0;
    //         for (int pile : piles) {
    //             if (pile < speed) {
    //                 time += 1;
    //             } else if (pile % speed == 0) {
    //                 time += (int) pile / speed;
    //             } else {
    //                 time += ((int) pile / speed) + 1;
    //             }
    //         }

    //         System.out.println(speed + ", " + time + ", " + result);

    //         if (time <= h) {
    //             result = speed;
    //             break;
    //         }
    //     }

    //     return result == -1 ? max : result;
    // }
}
