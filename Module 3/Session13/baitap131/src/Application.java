import bussiness.dao.IStudentDao;
import bussiness.dao.StudentDaoImpl;
import bussiness.service.StudentManagement;
import jdk.swing.interop.SwingInterOpUtils;
import utils.ConnectionDB;

import java.sql.Connection;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        IStudentDao studentDao = new StudentDaoImpl();
//        Connection conn = ConnectionDB.openConnection();
//        if(conn != null){
//            System.out.println("Thành công");
//        }
//        ConnectionDB.closeConnection(conn);
        do {
            System.out.println("""
            ========================== MENU QUẢN LÝ SINH VIÊN =====================
                    1. Hiển thị danh sách sinh viên.
                    2. Thêm mới sinh viên.
                    3. Sửa sinh viên.
                    4. Xóa sinh viên.
                    5. Tìm kiếm sinh viên.
                    6. Thoát
            ========================================================================
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:{
                    studentDao.getAllStudent().forEach(System.out::println);
                    break;
                }
                case 2:{
                    StudentManagement.addNewStudent(scanner);
                    break;
                }
                case 3:{
                    StudentManagement.updateStudent(scanner);
                    break;
                }
                case 4:{
                    StudentManagement.deleteStudentById(scanner);
                    break;
                }
                case 5:{
                    StudentManagement.findStudentById(scanner);
                    break;
                }
                case 6:{
                    System.out.println("Bạn đã thoát chương trình!");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        }while (true);
    }
}