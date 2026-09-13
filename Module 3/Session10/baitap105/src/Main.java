import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvoiceManager invoiceManager = new InvoiceManager();
        int choice;
        int currentId = 1;

        do {
            System.out.println("""
                    *********************** MENU QUẢN LÝ HÓA ĐƠN **************************
                    1. Thêm hóa đơn
                    2. Sửa hóa đơn
                    3. Xóa hóa đơn
                    4. Hiển thị danh sách hóa đơn
                    5. Thoát
                    """);

            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1: {
                    String invoiceCode;

                    do {
                        System.out.print("Nhập mã hóa đơn: ");
                        invoiceCode = scanner.nextLine();

                        if (invoiceCode.trim().isEmpty()) {
                            System.out.println("Vui lòng không để trống!");
                        } else if (invoiceManager.isInvoiceCodeExist(invoiceCode)) {
                            System.out.println("Mã hóa đơn đã tồn tại!");
                        } else {
                            break;
                        }

                    } while (true);

                    double amount;

                    while (true) {
                        try {
                            System.out.print("Nhập số tiền: ");
                            String amountInput = scanner.nextLine();

                            if (amountInput.trim().isEmpty()) {
                                System.out.println("Vui lòng không để trống!");
                            } else {
                                amount = Double.parseDouble(amountInput);

                                if (amount < 0) {
                                    System.out.println("Vui lòng nhập số thực >= 0 !");
                                } else {
                                    break;
                                }
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số!");
                        }
                    }

                    invoiceManager.add(new Invoice(currentId, invoiceCode, amount));
                    currentId++;

                    System.out.println("Hóa đơn đã được thêm thành công.");
                    break;
                }

                case 2: {
                    invoiceManager.display();

                    if (invoiceManager.findIndexById(1) == -1 && currentId == 1) {
                        break;
                    }

                    int id;

                    while (true) {
                        try {
                            System.out.print("Nhập id hóa đơn cần sửa: ");
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số!");
                        }
                    }

                    int index = invoiceManager.findIndexById(id);

                    if (index == -1) {
                        System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
                    } else {
                        String invoiceCode;

                        do {
                            System.out.print("Nhập mã hóa đơn mới: ");
                            invoiceCode = scanner.nextLine();

                            if (invoiceCode.trim().isEmpty()) {
                                System.out.println("Vui lòng không để trống!");
                            } else if (!invoiceCode.equalsIgnoreCase(
                                    invoiceManager.getInvoice(index).getInvoiceCode())
                                    && invoiceManager.isInvoiceCodeExist(invoiceCode)) {
                                System.out.println("Mã hóa đơn đã tồn tại!");
                            } else {
                                break;
                            }

                        } while (true);

                        double amount;

                        while (true) {
                            try {
                                System.out.print("Nhập số tiền mới: ");
                                String amountInput = scanner.nextLine();

                                if (amountInput.trim().isEmpty()) {
                                    System.out.println("Vui lòng không để trống!");
                                } else {
                                    amount = Double.parseDouble(amountInput);

                                    if (amount < 0) {
                                        System.out.println("Vui lòng nhập số thực >= 0 !");
                                    } else {
                                        break;
                                    }
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập số!");
                            }
                        }

                        invoiceManager.update(index, new Invoice(id, invoiceCode, amount));
                        System.out.println("Hóa đơn đã được sửa thành công.");
                    }

                    break;
                }

                case 3: {
                    invoiceManager.display();

                    if (currentId == 1) {
                        break;
                    }

                    int id;

                    while (true) {
                        try {
                            System.out.print("Nhập id hóa đơn cần xóa: ");
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số!");
                        }
                    }

                    int index = invoiceManager.findIndexById(id);

                    if (index == -1) {
                        System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
                    } else {
                        invoiceManager.delete(index);
                        System.out.println("Hóa đơn đã được xóa thành công.");
                    }

                    break;
                }

                case 4: {
                    invoiceManager.display();
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