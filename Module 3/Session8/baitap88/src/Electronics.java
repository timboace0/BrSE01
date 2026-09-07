public class Electronics extends Product{
    public Electronics() {
    }

    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public double getDiscount() {
        return 0.10;
    }
}
