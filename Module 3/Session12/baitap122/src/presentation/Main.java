package presentation;

import bussiness.model.Subject;
import bussiness.service.SubjectManager;
import utils.InputData;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubjectManager<Subject> subjectManager = new SubjectManager<>();
        int choice;
        do {
            System.out.println("""
                    1. Hiển thị danh sách môn học
                    2. Thêm môn học
                    3. Xóa môn học
                    4. Tìm kiếm môn học theo tên
                    5. Lọc môn học theo tín chỉ
                    6. Thoát
                    """);
            choice = InputData.getInt(scanner, "Nhập lựa chọn của bạn: ");
            switch (choice){
                case 1:{
                    subjectManager.displaySubjects();
                    break;
                }
                case 2:{
                    subjectManager.addSubject(scanner);
                    break;
                }
                case 3:{
                    subjectManager.removeSubject(scanner);
                    break;
                }
                case 4:{
                    subjectManager.searchByName(scanner);
                    break;
                }
                case 5:{
                    subjectManager.filterByCredits();
                    break;
                }
                case 6:{
                    System.out.println("Bạn đã thoát chương trình!");
                    System.exit(0);
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}