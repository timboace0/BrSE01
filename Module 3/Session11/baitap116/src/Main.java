import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ProductProcessor processor = new ProductProcessorImpl();
    int choice;
         List<Product> products = new ArrayList<>(
                List.of(
                        new Product("Iphone", 2000),
                        new Product("Samsung", 1500),
                        new Product("Xiaomi", 800),
                        new Product("Oppo", 1000),
                        new Product("Vivo", 900)
                )
        );
    do {
        System.out.println("""
                =================== PRODUCT MANAGEMENT =================
                1. CHECK EXPENSIVE PRODUCT
                2. PRINT TOTAL PRICE PRODUCT     
                3. PRINT PRODUCT LIST
                4. EXIT          
                """);
        System.out.println("Your choice: ");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:{
                if(processor.hasExpensiveProduct(products)){
                    System.out.println("There are expensive product in product list");
                } else {
                    System.out.println("There are no expensive items ");
                }
                break;
            }
            case 2:{
                System.out.printf("Total price in product list: %.2f%n", processor.calculateTotalValue(products));
                break;
            }
            case 3:{
                ProductProcessor.printProductList(products);
                break;
            }
            case 4:{
                System.out.println("you are exited");
                System.exit(0);
                break;
            }
            default:
                System.out.println("choice not available");
        }
    } while (true);


    }
}