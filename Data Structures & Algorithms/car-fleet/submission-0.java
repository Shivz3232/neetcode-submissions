class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[] temp = new int[position.length];
        for (int i = 0; i < position.length; i++) {
            temp[i] = (int) ((target - position[i]) / speed[i]);
        }

        HashMap<Integer, Integer> fleets = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            fleets.put(temp[i], fleets.getOrDefault(temp[i], 0) + 1);
        }

        return fleets.keySet().size();
    }
}
