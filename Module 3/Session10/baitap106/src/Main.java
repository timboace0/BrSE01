import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();

        do {
            System.out.println("""
                    *********************** MENU QUẢN LÝ ĐƠN HÀNG **************************
                    1. Thêm đơn hàng
                    2. Sửa đơn hàng
                    3. Xóa đơn hàng
                    4. Hiển thị danh sách đơn hàng
                    5. Thoát
                    """);

            System.out.print("Lựa chọn của bạn: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1: {
                    String orderCode;

                    do {
                        System.out.print("Nhập mã đơn hàng: ");
                        orderCode = scanner.nextLine();

                        if (orderCode.trim().isEmpty()) {
                            System.out.println("Vui lòng ko để trống !");
                        } else if (orderManager.isOrderCodeExist(orderCode)) {
                            System.out.println("Mã đơn hàng đã tồn tại!");
                        } else {
                            break;
                        }

                    } while (true);

                    String customerName;

                    do {
                        System.out.print("Nhập tên khách hàng: ");
                        customerName = scanner.nextLine();

                        if (customerName.trim().isEmpty()) {
                            System.out.println("Vui lòng ko để trống !");
                        }

                    } while (customerName.trim().isEmpty());

                    orderManager.add(new Order(orderCode, customerName));

                    System.out.println("Đơn hàng đã được thêm thành công.");
                    break;
                }

                case 2: {
                    orderManager.display();

                    try {
                        System.out.print("Nhập mã đơn hàng cần sửa: ");
                        String orderCode = scanner.nextLine();

                        int index = orderManager.findIndexByOrderCode(orderCode);

                        if (index == -1) {
                            throw new IllegalArgumentException(
                                    "Không tìm thấy đơn hàng có mã = " + orderCode
                            );
                        }

                        String customerName;

                        do {
                            System.out.print("Nhập tên khách hàng mới: ");
                            customerName = scanner.nextLine();

                            if (customerName.trim().isEmpty()) {
                                System.out.println("Vui lòng ko để trống !");
                            }

                        } while (customerName.trim().isEmpty());

                        orderManager.update(
                                index,
                                new Order(
                                        orderManager.getOrder(index).getOrderCode(),
                                        customerName
                                )
                        );

                        System.out.println("Đơn hàng đã được sửa thành công.");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 3: {
                    orderManager.display();

                    try {
                        System.out.print("Nhập mã đơn hàng cần xóa: ");
                        String orderCode = scanner.nextLine();

                        int index = orderManager.findIndexByOrderCode(orderCode);

                        if (index == -1) {
                            throw new IllegalArgumentException(
                                    "Không tìm thấy đơn hàng có mã = " + orderCode
                            );
                        }

                        orderManager.delete(index);

                        System.out.println("Đơn hàng đã được xóa thành công.");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 4: {
                    orderManager.display();
                    break;
                }

                case 5: {
                    System.out.println("Bạn đã thoát chương trình.");
                    return;
                }

                default: {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }

        } while (true);
    }
}