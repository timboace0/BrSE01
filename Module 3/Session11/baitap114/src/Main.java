import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    ----- Product Management System -----
                    1. Add Product
                    2. Edit Product
                    3. Delete Product
                    4. Display Product
                    5. Filter Products (Price > 100)
                    6. total Value of Products
                    0. Exit
                    """);
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1: {
                    ProductManagement.addProduct(scanner);
                    break;
                }case 2: {
                    ProductManagement.editProduct(scanner);
                    break;
                }case 3: {
                    ProductManagement.deleteProduct(scanner);
                    break;
                }case 4: {
                    ProductManagement.displayProduct();
                    break;
                }case 5: {
                    ProductManagement.filterProduct();
                    break;
                }case 6: {
                    ProductManagement.totalPrice();
                    break;
                }case 0: {
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Choice not available");
            }
        } while (true);
    }
}