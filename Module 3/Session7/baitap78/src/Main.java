import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Student[] students = new Student[100];
    int count = 0, choice;

    do {
        System.out.println("""
          ===================== QUẢN LÝ SINH VIÊN ====================
          1. Hiển thị danh sách sinh viên
          2. Thêm mới sinh viên
          3. Sửa thông tin sinh viên
          4. Xóa sinh viên  
          5. Thoát
                """);

        System.out.print("Nhập lựa chọn của bạn: ");
        choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:

                if (count == 0) {
                    System.out.println("Danh sách sinh viên đang trống!");
                    break;
                }

                System.out.println("\n========== DANH SÁCH SINH VIÊN ==========");

                for (int i = 0; i < count; i++) {
                    students[i].displayData();
                }

                break;
            case 2:

                if (count == students.length) {
                    System.out.println("Danh sách đã đầy!");
                    break;
                }

                Student newStudent = new Student();

                newStudent.inputData(scanner);

                students[count] = newStudent;

                count++;

                System.out.println("Thêm sinh viên thành công!");

                break;
            case 3:

                if (count == 0) {
                    System.out.println("Danh sách sinh viên đang trống!");
                    break;
                }

                System.out.print("Nhập mã sinh viên cần sửa: ");
                int editId = Integer.parseInt(scanner.nextLine());

                int editIndex = -1;
                for (int i = 0; i < count; i++) {

                    if (students[i].getId() == editId) {
                        editIndex = i;
                        break;
                    }
                }

                if (editIndex == -1) {
                    System.out.println("Không tìm thấy sinh viên!");
                } else {

                    System.out.println("Nhập thông tin mới:");

                    students[editIndex].inputData(scanner);

                    System.out.println("Cập nhật thành công!");
                }

                break;

            case 4:

                if (count == 0) {
                    System.out.println("Danh sách sinh viên đang trống!");
                    break;
                }

                System.out.print("Nhập mã sinh viên cần xóa: ");
                int deleteId = Integer.parseInt(scanner.nextLine());

                int deleteIndex = -1;
                for (int i = 0; i < count; i++) {

                    if (students[i].getId() == deleteId) {
                        deleteIndex = i;
                        break;
                    }
                }

                if (deleteIndex == -1) {
                    System.out.println("Không tìm thấy sinh viên!");

                } else {
                    for (int i = deleteIndex; i < count - 1; i++) {
                        students[i] = students[i + 1];
                    }
                    students[count - 1] = null;
                    count--;

                    System.out.println("Xóa sinh viên thành công!");
                }
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