import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {
    double calculateTotalValue(List<Product> products);

    default boolean hasExpensiveProduct(List<Product> products) {
        Predicate<Product> expensiveProduct = product -> product.getPrice() > 100;
        for(Product product : products){
            if(expensiveProduct.test(product)){
                return true;
            }
        }
        return false;
    }

    static void printProductList(List<Product> products) {
        products.forEach(System.out::println);
    }
}
