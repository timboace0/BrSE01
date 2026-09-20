package presentation;

import bussiness.service.OrderManager;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        OrderManager orderManager = new OrderManager();

        System.out.print("Nhập customer id: ");
        int customerId = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tổng tiền: ");
        BigDecimal totalAmount = new BigDecimal(scanner.nextLine());

        System.out.print("Nhập product id: ");
        int productId = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        orderManager.placeOrder(
                customerId,
                totalAmount,
                productId,
                quantity
        );
    }
}