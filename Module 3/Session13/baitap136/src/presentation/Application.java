package presentation;

import bussiness.service.TaskService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
        
        ========== TO-DO LIST ==========
        1. Thêm công việc
        2. Liệt kê công việc
        3. Cập nhật trạng thái
        4. Xóa công việc
        5. Tìm kiếm công việc
        6. Thống kê công việc
        0. Thoát
        Mời chọn chức năng:
        """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    TaskService.addTask(scanner);
                    break;

                case "2":
                    TaskService.listTasks();
                    break;

                case "3":
                    TaskService.updateTaskStatus(scanner);
                    break;

                case "4":
                    TaskService.deleteTask(scanner);
                    break;

                case "5":
                    TaskService.searchTaskByName(scanner);
                    break;

                case "6":
                    TaskService.taskStatistics();
                    break;

                case "0":
                    System.out.println("Đã thoát chương trình!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}