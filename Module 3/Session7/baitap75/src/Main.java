import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, count = 0;
        int index = -1;
        boolean flag = false;
        Product[] productList = new Product[10];
        do {
            System.out.println("""
                    1. Thêm mới sản phẩm
                    2. Hiển thị danh sách sản phẩm
                    3. Cập nhật sản phẩm
                    4. Xóa sản phẩm
                    5. Thoát
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:{
                    System.out.print("Nhập ID sản phẩm: ");
                    String id = scanner.nextLine();

                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập giá sản phẩm: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product product = new Product(id,name,price);
                    productList[count] = product;
                    count++;
                    System.out.println("Sản phẩm đã được thêm.");
                    break;
                }
                case 2:{
                    System.out.println("Danh sách sản phẩm:");
                    for (int i = 0; i < productList.length; i++) {
                        if(productList[i] != null){
                            System.out.printf("ID: %s, Tên: %s, Giá: %f%n", productList[i].getId(), productList[i].getName(), productList[i].getPrice());
                        } else {
                            System.out.println("Không có sản phẩm nào!");
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String value = scanner.nextLine();
                    for (int i = 0; i < productList.length; i++) {
                        if(productList[i] != null && Objects.equals(productList[i].getId(), value)){
                            flag = true;
                            index = i;
                            break;
                        }
                    }

                    if(flag){
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nhập giá mới: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        productList[index].setName(newName);
                        productList[index].setPrice(newPrice);
                        System.out.println("Sản phẩm đã được cập nhật.");
                        flag = false;
                        index = -1;
                    } else {
                        System.out.println("Không tìm thấy ID sản phẩm!");
                    }
                    break;
                }
                case 4:{
                    System.out.print("Nập ID sản phẩm cần xóa: ");
                    String delId = scanner.nextLine();

                    for (int i = 0; i < productList.length; i++) {
                        if(productList[i] != null && productList[i].getId().equals(delId)){
                            flag = true;
                            index = i;
                            break;
                        }
                    }

                    if(flag){
                        for(int i = index; i < productList.length - 1; i++){
                            productList[i] = productList[i+1];
                        }

                        productList[productList.length - 1] = null;
                        System.out.println("Xóa sản phẩm thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }
}