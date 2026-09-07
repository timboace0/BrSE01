public abstract class Car {
    protected String model;
    protected int year;
    protected double price;

    public Car() {
    }

    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public abstract String start();

    public abstract String stop();
}