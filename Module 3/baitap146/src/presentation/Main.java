package presentation;

import bussiness.service.EmployeeProjectManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EmployeeProjectManager manager =
                new EmployeeProjectManager();

        System.out.print("Nhập ID nhân viên: ");
        int employeeId = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập ID dự án: ");
        int projectId = Integer.parseInt(scanner.nextLine());

        manager.assignEmployeeToProject(employeeId, projectId);
    }
}