package presentation;

import bussiness.model.Course;
import bussiness.model.Student;
import bussiness.service.StudentManagerService;
import utils.InputData;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("""
                    
                    ================================
                    QUAN LY SINH VIEN VA KHOA HOC
                    ================================
                    1. Them sinh vien
                    2. Them khoa hoc
                    3. Ghi danh sinh vien vao khoa hoc
                    4. Hien thi danh sach sinh vien va diem
                    5. Cap nhat diem sinh vien
                    0. Thoat
                    ================================
                    """);

            int choice = InputData.getInt(scanner, "Nhap lua chon: ");

            switch (choice) {
                case 1:
                    String studentName = InputData.getString(
                            scanner,
                            "Nhap ten sinh vien: "
                    );

                    String email = InputData.getString(
                            scanner,
                            "Nhap email: "
                    );

                    Student student = new Student(
                            studentName,
                            email
                    );

                    StudentManagerService.addStudent(student);
                    break;

                case 2:
                    String title = InputData.getString(
                            scanner,
                            "Nhap ten khoa hoc: "
                    );

                    int credits = InputData.getInt(
                            scanner,
                            "Nhap so tin chi: "
                    );

                    Course course = new Course(
                            title,
                            credits
                    );

                    StudentManagerService.addCourse(course);
                    break;

                case 3:
                    int studentId = InputData.getInt(
                            scanner,
                            "Nhap ID sinh vien: "
                    );

                    int courseId = InputData.getInt(
                            scanner,
                            "Nhap ID khoa hoc: "
                    );

                    StudentManagerService.enrollStudent(
                            studentId,
                            courseId
                    );
                    break;

                case 4:
                    StudentManagerService.listStudentsAndGrades();
                    break;

                case 5:
                    int updateStudentId = InputData.getInt(
                            scanner,
                            "Nhap ID sinh vien: "
                    );

                    int updateCourseId = InputData.getInt(
                            scanner,
                            "Nhap ID khoa hoc: "
                    );

                    double grade = Double.parseDouble(
                            InputData.getString(
                                    scanner,
                                    "Nhap diem: "
                            )
                    );

                    StudentManagerService.updateStudentGrade(
                            updateStudentId,
                            updateCourseId,
                            grade
                    );
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    return;

                default:
                    System.out.println("Lua chon khong hop le");
            }

        } while (true);
    }
}