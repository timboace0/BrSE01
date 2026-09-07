//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product product = new Product("Product", 1000);
        Product electronics = new Electronics("Laptop", 1000);
        Product clothing = new Clothing("Áo", 1000);
        Product food = new Food("Bánh", 1000);

        System.out.println("Product:");
        System.out.println("Giá sau chiết khấu: " + product.getFinalPrice());
        System.out.println("Giá sau chiết khấu 150 sản phẩm: " + product.getFinalPrice(150));

        System.out.println();

        System.out.println("Electronics:");
        System.out.println("Giá sau chiết khấu: " + electronics.getFinalPrice());
        System.out.println("Giá sau chiết khấu 150 sản phẩm: " + electronics.getFinalPrice(150));

        System.out.println();

        System.out.println("Clothing:");
        System.out.println("Giá sau chiết khấu: " + clothing.getFinalPrice());
        System.out.println("Giá sau chiết khấu 150 sản phẩm: " + clothing.getFinalPrice(150));

        System.out.println();

        System.out.println("Food:");
        System.out.println("Giá sau chiết khấu: " + food.getFinalPrice());
        System.out.println("Giá sau chiết khấu 150 sản phẩm: " + food.getFinalPrice(150));
    }
}