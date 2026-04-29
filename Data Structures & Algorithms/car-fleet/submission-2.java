class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort(Comparator.comparingInt(Car::position));
        
        int fleets = 0;
        double curFleetTime;
        for (int i = 0; i < cars.size(); i++) {
            
            if (fleets == 0) {
                fleets++;
                curFleetTime = cars.get(i).time(target);
            } else if (ca)
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

        public double time(int target) {
            return (target - this.position) / this.speed;
        }

        @Override
        public String toString() {
            return "Position: " + this.position + ", Speed: " + this.speed;
        }
    }
}
