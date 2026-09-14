import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManagement {
    static HashMap<Integer, Product> products = new HashMap<>();

    public static void addProduct(Scanner scanner){
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        if(isProductIdExisted(id) != -1){
            System.out.println("Your ID has been existed!");
            return;
        }
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        products.put(id,new Product(id,name,price));
        System.out.println("Product added successfully.");
    }

    public static void editProduct(Scanner scanner){
        displayProduct();
        System.out.print("Enter Product ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        int value = isProductIdExisted(id);
        if(value != -1){
            System.out.print("Enter new product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new product price: ");
            double price = Double.parseDouble(scanner.nextLine());
            products.put(value, new Product(value,name,price));
            System.out.println("Product updated successfully.");
        }  else {
            System.out.println("Product ID not found");
        }
    }

    public static void deleteProduct(Scanner scanner){
        displayProduct();
        System.out.print("Enter Product ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        int value = isProductIdExisted(id);
        if(value != -1){
            products.remove(value);
            System.out.println("Product deleted successfully.");
        }  else {
            System.out.println("Product ID not found");
        }
    }

    public static void displayProduct(){
        products.forEach((key,value) ->
        {
            System.out.println(value);
        });
    }

    public static void filterProduct(){
        System.out.println("Products with price greater than 100: ");
        products.forEach((key,value) -> {
                if(value.getPrice() > 100){
                    System.out.println(value);
                }
        });
    }

    public static void totalPrice(){
        double total = products.values().stream().mapToDouble(Product::getPrice).sum();
        System.out.printf("Total value of products: %.2f%n" , total);
    }

    public static int isProductIdExisted(int id){
        if(products.containsKey(id)){
            return id;
        }
        return -1;
    }
}
