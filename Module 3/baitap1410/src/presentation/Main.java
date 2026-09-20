package presentation;

import bussiness.model.Course;
import bussiness.model.Grade;
import bussiness.model.Student;
import bussiness.service.StudentManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        do {
            System.out.println("""
                    
                    ========== STUDENT MANAGEMENT ==========
                    1. Thêm sinh viên
                    2. Thêm khóa học
                    3. Cập nhật điểm sinh viên
                    4. Hiển thị danh sách sinh viên
                    5. Thoát
                    ========================================
                    """);

            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();

                    Student student = new Student(
                            0,
                            name,
                            email
                    );

                    studentManager.addStudent(student);
                    break;

                case 2:
                    System.out.print("Nhập tên khóa học: ");
                    String title = scanner.nextLine();

                    Course course = new Course(
                            0,
                            title
                    );

                    studentManager.addCourse(course);
                    break;

                case 3:
                    System.out.print("Nhập ID sinh viên: ");
                    int studentId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập số lượng môn học: ");
                    int numberOfGrades = Integer.parseInt(scanner.nextLine());

                    List<Grade> grades = new ArrayList<>();

                    for (int i = 0; i < numberOfGrades; i++) {

                        System.out.println("\nMôn học thứ " + (i + 1));

                        System.out.print("Nhập ID khóa học: ");
                        int courseId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập điểm: ");
                        BigDecimal grade =
                                new BigDecimal(scanner.nextLine());

                        grades.add(
                                new Grade(courseId, grade)
                        );
                    }

                    studentManager.updateGrades(
                            studentId,
                            grades
                    );

                    break;

                case 4:
                    studentManager.listStudents();
                    break;

                case 5:
                    System.out.println("Đã thoát chương trình!");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (true);
    }
}