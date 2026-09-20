package presentation;

import bussiness.service.BankManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankManager bankManager = new BankManager();

        do {

            System.out.println("""
                    
                    ========== BANK MANAGEMENT ==========
                    1. Chuyển tiền
                    2. Xem thông tin tài khoản
                    3. Xem lịch sử giao dịch
                    4. Thoát
                    ======================================
                    """);

            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Nhập ID tài khoản gửi: ");
                    int fromAccountId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập ID tài khoản nhận: ");
                    int toAccountId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập số tiền chuyển: ");
                    double amount =
                            Double.parseDouble(scanner.nextLine());

                    bankManager.transferMoney(
                            fromAccountId,
                            toAccountId,
                            amount
                    );

                    break;

                case 2:

                    System.out.print("Nhập ID tài khoản: ");
                    int accountId =
                            Integer.parseInt(scanner.nextLine());

                    bankManager.getAccountInfo(accountId);

                    break;

                case 3:

                    System.out.print("Nhập ID tài khoản: ");
                    int transactionAccountId =
                            Integer.parseInt(scanner.nextLine());

                    bankManager.listTransactions(
                            transactionAccountId
                    );

                    break;

                case 4:

                    System.out.println("Đã thoát chương trình!");
                    return;

                default:

                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (true);
    }
}