import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager attendanceManager = new AttendanceManager();
        int choice;

        do {
            System.out.println("""
                    *********************** MENU QUẢN LÝ ĐIỂM DANH **************************
                    1. Thêm sinh viên
                    2. Sửa sinh viên
                    3. Xóa sinh viên
                    4. Hiển thị danh sách sinh viên
                    5. Thoát
                   
                    """);
                    System.out.print("Lựa chọn của bạn: ");
                    choice = Integer.parseInt(scanner.nextLine());

                    switch (choice){
                        case 1:{

                            int id;
                            do {
                                try {
                                    System.out.print("Nhập ID sinh viên: ");
                                    String idInput = scanner.nextLine();
                                    if(idInput.isEmpty()){
                                        System.out.println("ID không được để trống");
                                    } else if(attendanceManager.isIdExist(Integer.parseInt(idInput))) {
                                        System.out.println("ID đã tồn tại!");
                                    } else {
                                        id = Integer.parseInt(idInput);
                                        break;
                                    }
                                } catch (NumberFormatException e){
                                    System.out.println("ID phải là số");
                                }
                            } while(true);

                            String name;

                            do {
                                System.out.print("Nhập tên: ");
                                name = scanner.nextLine();

                                if (name.trim().isEmpty()) {
                                    System.out.println("Tên không được để trống!");
                                }

                            } while (name.trim().isEmpty());
                            attendanceManager.add(new Student(id, name));
                            System.out.println("Thêm sinh viên thành công!");
                            break;
                        }
                        case 2:{
                            attendanceManager.display();
                            System.out.print("Nhập ID sinh viên cần sửa: ");
                            int value = Integer.parseInt(scanner.nextLine());
                            int index = attendanceManager.findIndexById(value);
                            if(index == -1){
                                System.out.println("Không tìm thấy ID sinh viên");
                            } else {
                                System.out.print("Nhập tên mới sinh viên: ");
                                String name = scanner.nextLine();
                                if (name.trim().isEmpty()) {
                                    System.out.println("Tên không được để trống!");
                                } else {
                                    attendanceManager.update(index, new Student(value, name));
                                    System.out.println("Sửa sinh viên thành công");
                                }
                            }
                            break;
                        }
                        case 3:{
                            attendanceManager.display();
                            System.out.print("Nhập ID sinh viên cần xóa: ");
                            int value = Integer.parseInt(scanner.nextLine());
                            int index = attendanceManager.findIndexById(value);
                            if(index == -1){
                                System.out.println("Không tìm thấy ID sinh viên");
                            } else {
                                attendanceManager.delete(index);
                                System.out.println("Xóa sinh viên thành công");
                            }
                            break;
                        }
                        case 4:{
                            attendanceManager.display();
                            break;
                        }
                        case 5:{
                            System.out.println("Bạn đã thoát chương trình");
                            System.exit(0);
                            break;
                        }
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                    }
        } while(true);
    }
}