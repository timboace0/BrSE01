import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ProductProcessorImpl implements ProductProcessor {

    @Override
    public double calculateTotalValue(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }


}
