package bussiness.service;

import bussiness.dao.IManagementDao;
import bussiness.dao.ManagementDaoImpl;
import bussiness.model.Employee;
import bussiness.model.Project;
import utils.InputData;

import java.math.BigDecimal;
import java.util.Scanner;

public class ManagementService {

    static IManagementDao iManagementDao =
            new ManagementDaoImpl();

    public static void addEmployee(Scanner scanner) {

        String name = InputData.getString(
                scanner,
                "Mời nhập tên nhân viên: "
        );

        String department = InputData.getString(
                scanner,
                "Mời nhập phòng ban: "
        );

        BigDecimal salary = getMoney(
                scanner,
                "Mời nhập lương: "
        );

        Employee employee =
                new Employee(
                        name,
                        department,
                        salary
                );

        boolean result =
                iManagementDao.addEmployee(employee);

        if (result) {
            System.out.println(
                    "Thêm nhân viên thành công!"
            );
        } else {
            System.out.println(
                    "Nhân viên đã tồn tại!"
            );
        }
    }

    public static void addProject(Scanner scanner) {

        String name = InputData.getString(
                scanner,
                "Mời nhập tên dự án: "
        );

        BigDecimal budget = getMoney(
                scanner,
                "Mời nhập ngân sách dự án: "
        );

        Project project =
                new Project(name, budget);

        boolean result =
                iManagementDao.addProject(project);

        if (result) {
            System.out.println(
                    "Thêm dự án thành công!"
            );
        } else {
            System.out.println(
                    "Dự án đã tồn tại!"
            );
        }
    }

    public static void assignEmployeeToProject(
            Scanner scanner
    ) {

        int employeeId = InputData.getInt(
                scanner,
                "Mời nhập ID nhân viên: "
        );

        int projectId = InputData.getInt(
                scanner,
                "Mời nhập ID dự án: "
        );

        String role = InputData.getString(
                scanner,
                "Mời nhập vai trò: "
        );

        boolean result =
                iManagementDao.assignEmployeeToProject(
                        employeeId,
                        projectId,
                        role
                );

        if (result) {
            System.out.println(
                    "Gán nhân viên vào dự án thành công!"
            );
        } else {
            System.out.println(
                    "Không thể gán nhân viên. Kiểm tra Employee ID, Project ID hoặc nhân viên đã được gán!"
            );
        }
    }

    public static void listEmployeesAndProjects() {

        iManagementDao.listEmployeesAndProjects();
    }

    public static void updateEmployeeSalary(
            Scanner scanner
    ) {

        int employeeId = InputData.getInt(
                scanner,
                "Mời nhập ID nhân viên: "
        );

        BigDecimal salary = getMoney(
                scanner,
                "Mời nhập mức lương mới: "
        );

        boolean result =
                iManagementDao.updateEmployeeSalary(
                        employeeId,
                        salary.doubleValue()
                );

        if (result) {
            System.out.println(
                    "Cập nhật lương thành công!"
            );
        } else {
            System.out.println(
                    "Không tìm thấy nhân viên!"
            );
        }
    }

    private static BigDecimal getMoney(
            Scanner scanner,
            String suggestion
    ) {

        while (true) {

            String input =
                    InputData.getString(
                            scanner,
                            suggestion
                    );

            try {

                BigDecimal value =
                        new BigDecimal(input);

                if (value.compareTo(BigDecimal.ZERO) > 0) {
                    return value;
                }

                System.out.println(
                        "Giá trị phải lớn hơn 0!"
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Vui lòng nhập một số hợp lệ!"
                );
            }
        }
    }
}