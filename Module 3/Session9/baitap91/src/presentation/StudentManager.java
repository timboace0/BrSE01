package presentation;

import bussiness.StudentService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    *********************QUẢN LÝ SINH VIÊN********************
                    
                    1. Hiển thị danh sách sinh viên
                    
                    2. Thêm sinh viên
                    
                    3. Cập nhật thông tin sinh viên theo mã sinh viên
                    
                    4. Xóa sinh viên theo mã sinh viên
                    
                    5. Tìm sinh viên theo tên sinh viên
                    
                    6. Thoát
                    
                    Lựa chọn của bạn:
                    """);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:{
                    StudentService.displayListStudents();
                    break;
                }
                case 2:{
                    StudentService.addStudent(scanner);
                    break;
                }
                case 3:{
                    StudentService.updateStudent(scanner);
                    break;
                }
                case 4:{
                    StudentService.deleteStudent(scanner);
                    break;
                }
                case 5:{
                    StudentService.searchStudentByName(scanner);
                    break;
                }
                case 6:{
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không đúng");
            }
        } while (true);
    }
}