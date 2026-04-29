class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort(Comparator.comparingInt(Car::position).reversed());

        System.out.println(cars);
        
        int fleets = 1;
        double curFleetTime = cars.get(0).time(target);
        for (int i = 1; i < cars.size(); i++) {
            Car car = cars.get(i);

            // System.out.println(fleets);
            // System.out.println("curFleetTime: " + curFleetTime + ", car time: " + car.time(target));

            if (car.time(target) <= curFleetTime) {
                continue;
            }

            fleets++;
            curFleetTime = car.time(target);
        }

        System.out.println(fleets);

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

        public double time(double target) {
            return (target - this.position) / this.speed;
        }

        @Override
        public String toString() {
            return "Position: " + this.position + ", Speed: " + this.speed;
        }
    }
}
