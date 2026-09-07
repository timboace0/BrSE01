public class Product {
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getDiscount() {
        return 0;
    }

    public double getFinalPrice() {
        return price - (price * getDiscount());
    }

    public double getDiscount(int quantity) {
        if (quantity > 100) {
            return 0.05;
        }
        return getDiscount();
    }

    public double getFinalPrice(int quantity) {
        return price - (price * getDiscount(quantity));
    }
}
