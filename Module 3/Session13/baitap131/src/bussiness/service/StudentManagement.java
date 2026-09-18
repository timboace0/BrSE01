package bussiness.service;

import bussiness.dao.IStudentDao;
import bussiness.dao.StudentDaoImpl;
import bussiness.model.Student;

import javax.swing.text.DateFormatter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StudentManagement {
    static IStudentDao studentDao = new StudentDaoImpl();
    public static void addNewStudent(Scanner scanner){
        System.out.print("Nhập họ tên sinh viên: ");
        String name = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate dob = null;
        while (dob == null){
            System.out.print("Nhập sinh nhật (dd-MM-yyyy): ");
            String input = scanner.nextLine();
            try {
                dob = LocalDate.parse(input, dtf);
            } catch (DateTimeException e){
                System.out.println("Nhập sai định dạng vui lòng nhập lại!");
            }
        }

        System.out.print("Nhập email sinh viên: ");
        String email = scanner.nextLine();

        studentDao.addStudent(new Student(name, dob, email));
        System.out.println("Thêm mới sinh viên thành công!");
    }

    public static void updateStudent(Scanner scanner){
        studentDao.getAllStudent().forEach(System.out::println);
        System.out.print("Nhập ID sinh viên cần update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = studentDao.findStudentById(id);
        if(s == null){
            System.out.println("Không tìm thấy ID sinh viên!");
        } else {
            System.out.print("Nhập họ tên mới sinh viên: ");
            String name = scanner.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            LocalDate dob = null;
            while (dob == null){
                System.out.print("Nhập sinh nhật mới (dd-MM-yyyy): ");
                String input = scanner.nextLine();
                try {
                    dob = LocalDate.parse(input, dtf);
                } catch (DateTimeException e){
                    System.out.println("Nhập sai định dạng vui lòng nhập lại!");
                }
            }

            System.out.print("Nhập email mới sinh viên: ");
            String email = scanner.nextLine();

            studentDao.updateStudent(new Student(id,name,dob,email));
            System.out.println("Cập nhật sinh viên thành công!");
        }
    }

    public static void findStudentById(Scanner scanner){
        System.out.print("Nhập ID sinh viên để tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = studentDao.findStudentById(id);
        if(s == null){
            System.out.println("Không tìm thấy ID sinh viên!");
        } else {
            System.out.println("Đã tìm thấy sinh viên!");
            System.out.println(s);
        }
    }

    public static void deleteStudentById(Scanner scanner){
        studentDao.getAllStudent().forEach(System.out::println);
        System.out.print("Nhập ID sinh viên để xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = studentDao.findStudentById(id);
        if(s == null){
            System.out.println("Không tìm thấy ID sinh viên!");
        } else {
            studentDao.deleteStudentById(id);
            System.out.println("Xóa sinh viên thành công!");
        }
    }
}
