import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        do {
            System.out.println("""
                    *********************** MENU QUẢN LÝ SINH VIÊN **************************
                    1. Thêm sinh viên
                    2. Hiển thị danh sách sinh viên
                    3. Tìm kiếm sinh viên theo tên
                    4. Phân loại sinh viên theo GPA
                    5. Thoát
                    """);

            System.out.print("Lựa chọn của bạn: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {

                case 1: {
                    int id;

                    while (true) {
                        try {
                            System.out.print("Nhập ID sinh viên: ");
                            String idInput = scanner.nextLine();

                            if (idInput.trim().isEmpty()) {
                                System.out.println("ID không được để trống!");
                            } else {
                                id = Integer.parseInt(idInput);
                                break;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("ID phải là số!");
                        }
                    }

                    String name;

                    do {
                        System.out.print("Nhập tên sinh viên: ");
                        name = scanner.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Tên không được để trống!");
                        }

                    } while (name.trim().isEmpty());

                    double gpa;

                    while (true) {
                        try {
                            System.out.print("Nhập GPA: ");
                            String gpaInput = scanner.nextLine();

                            if (gpaInput.trim().isEmpty()) {
                                System.out.println("GPA không được để trống!");
                            } else {
                                gpa = Double.parseDouble(gpaInput);

                                if (gpa < 0 || gpa > 10) {
                                    System.out.println("GPA phải nằm trong khoảng từ 0 đến 10!");
                                } else {
                                    break;
                                }
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("GPA phải là số!");
                        }
                    }

                    students.add(new Student(id, name, gpa));

                    System.out.println("Thêm sinh viên thành công!");
                    break;
                }

                case 2: {
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên đang trống!");
                    } else {
                        System.out.println("**************** DANH SÁCH SINH VIÊN ****************");

                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }

                    break;
                }

                case 3: {
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên đang trống!");
                        break;
                    }

                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String searchName = scanner.nextLine().trim();

                    boolean found = false;

                    for (Student student : students) {
                        if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                            System.out.println(student);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên!");
                    }

                    break;
                }

                case 4: {
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên đang trống!");
                        break;
                    }

                    System.out.println("**************** PHÂN LOẠI SINH VIÊN ****************");

                    for (Student student : students) {
                        String classification;

                        if (student.getGpa() >= 8.5) {
                            classification = "Xuất sắc";
                        } else if (student.getGpa() >= 7.0) {
                            classification = "Giỏi";
                        } else if (student.getGpa() >= 5.5) {
                            classification = "Khá";
                        } else {
                            classification = "Trung bình/Yếu";
                        }

                        System.out.println(
                                student + ", Xếp loại: " + classification
                        );
                    }

                    break;
                }

                case 5: {
                    System.out.println("Bạn đã thoát chương trình!");
                    return;
                }

                default: {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }

        } while (true);
    }
}