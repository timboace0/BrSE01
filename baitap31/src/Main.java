import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Xin mời nhập tên khách hàng: ");
        String customerName = scanner.nextLine();

        System.out.print("Xin mời nhập tên sản phẩm: ");
        String productName = scanner.nextLine();

        System.out.print("Xin mời nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Xin mời nhập số lượng mua: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Có phải là thành viên? (True/False)");
        boolean isMember = Boolean.parseBoolean(scanner.nextLine());

        double totalAmount = price * quantity;

        double discount = 0;
        if(isMember){
            discount = totalAmount * 0.1;
        }

        double vat = (totalAmount - discount) * 0.08;

        double payment = totalAmount - discount + vat;

        System.out.printf("""
                =============================THÔNG TIN HÓA ĐƠN================================
                Khách hàng: %s
                Sản phẩm: %s
                Giá: %.3f VND
                Số lượng: %d
                Thành tiền: %.3f VND
                Giảm giá: %.3f VND
                Tiền VAT: %.3f VND
                Tổng Thanh toán: %.3f VND
                ==============================================================================
                """, customerName, productName, price, quantity, totalAmount, discount, vat, payment);
    }
}