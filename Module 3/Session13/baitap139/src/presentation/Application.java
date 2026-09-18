package presentation;

import bussiness.service.ManagementService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("""
                    
                    ==============================================
                       EMPLOYEE & PROJECT MANAGEMENT SYSTEM
                    ==============================================
                    1. Thêm nhân viên
                    2. Thêm dự án
                    3. Gán nhân viên vào dự án
                    4. Hiển thị nhân viên và dự án
                    5. Cập nhật lương nhân viên
                    0. Thoát
                    ==============================================
                    """);

            System.out.print(
                    "Mời bạn chọn chức năng: "
            );

            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":
                    ManagementService.addEmployee(
                            scanner
                    );
                    break;

                case "2":
                    ManagementService.addProject(
                            scanner
                    );
                    break;

                case "3":
                    ManagementService.assignEmployeeToProject(
                            scanner
                    );
                    break;

                case "4":
                    ManagementService.listEmployeesAndProjects();
                    break;

                case "5":
                    ManagementService.updateEmployeeSalary(
                            scanner
                    );
                    break;

                case "0":
                    System.out.println(
                            "Đã thoát chương trình!"
                    );
                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "Lựa chọn không hợp lệ!"
                    );
            }

        } while (true);
    }
}