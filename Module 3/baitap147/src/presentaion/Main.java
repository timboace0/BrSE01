package presentation;

import bussiness.service.HotelManager;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HotelManager hotelManager = new HotelManager();

        do {
            System.out.println("""
                    
                    ========== HOTEL MANAGEMENT ==========
                    1. Đặt phòng
                    2. Hủy đặt phòng
                    3. Hiển thị phòng còn trống
                    4. Thoát
                    ======================================
                    """);

            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Nhập ID phòng: ");
                    int roomId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                    Date startDate = Date.valueOf(scanner.nextLine());

                    System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
                    Date endDate = Date.valueOf(scanner.nextLine());

                    hotelManager.bookRoom(
                            roomId,
                            customerName,
                            startDate,
                            endDate
                    );
                    break;

                case 2:
                    System.out.print("Nhập ID booking cần hủy: ");
                    int bookingId = Integer.parseInt(scanner.nextLine());

                    hotelManager.cancelBooking(bookingId);
                    break;

                case 3:
                    hotelManager.listAvailableRooms();
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