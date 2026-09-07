public class Bike extends Vehicle{
    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    void displayInfo() {
        System.out.printf("Bike Name: %s, Speed: %d km/h", getName(), getSpeed());
    }
}
