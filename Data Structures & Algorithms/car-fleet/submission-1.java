class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort(Comparator.comparingInt(Car::position));
        
        int fleets = 1;
        int curFleetTime = (target - cars.get(0).position()) / cars.get(0).speed();
        for (int i = 1; i < cars.size(); i++) {
            Car c = cars.get(i);
            int curCarTime = (target - c.position()) / c.speed();

            if (curCarTime < curFleetTime) {
                curFleetTime = curCarTime;
                fleets++;
            }
        }

        return fleets;
    }

    private class Car {
        private final int position;
        private final int speed;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        public int position() {
            return this.position;
        }

        public int speed() {
            return this.speed;
        }

        @Override
        public String toString() {
            return "Position: " + this.position + ", Speed: " + this.speed;
        }
    }
}
