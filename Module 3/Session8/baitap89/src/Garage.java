public class Garage {
    private Car[] cars = new Car[100];

    public void addCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = car;
                return;
            }
        }
    }

    public void startAll() {
        for (Car car : cars) {
            if (car != null) {
                System.out.println(car.start());
            }
        }
    }

    public void stopAll() {
        for (Car car : cars) {
            if (car != null) {
                System.out.println(car.stop());
            }
        }
    }

    public void refuelAll() {
        for (Car car : cars) {
            if (car != null && car instanceof Refuelable) {
                Refuelable refuelable = (Refuelable) car;
                refuelable.refuel();
            }
        }
    }
}