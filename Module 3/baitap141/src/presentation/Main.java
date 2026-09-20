package presentation;

import bussiness.model.Student;
import bussiness.service.StudentManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Connection conn = ConnectionDB.openConnection();
//        if(conn!= null) {
//            System.out.println("Thành công!");
//        }

        StudentManager studentManager = new StudentManager();

        List<Student> students = Arrays.asList(
                new Student("Nguyễn Văn A", 20),
                new Student("Trần Thị B", 22),
                new Student("Lê Văn C", 19)
        );

//        studentManager.addStudents(students);

        Student student = new Student(1, "Nguyễn Văn A", 21);
//        studentManager.updateStudent(student);

//        System.out.print("Nhập tuổi để xóa những học sinh có độ tuổi nhỏ hơn: ");
//        int age = Integer.parseInt(scanner.nextLine());
//        int count = studentManager.deleteStudentByAge(age);
//        System.out.print("Xóa thành công " + count + " học sinh có độ tuổi nhỏ hơn: " +age);

    }
}