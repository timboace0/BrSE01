import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        String regex = "^\\d{2}F-\\d{3}\\.\\d{2}$";

        String[] licensePlateArr = null;

        do {
            System.out.println("""
                    ******************QUẢN LÝ BIỂN SỐ XE****************
                    1. Thêm các biển số xe
                    2. Hiển thị danh sách biển số xe
                    3. Tìm kiếm biển số xe
                    4. Tìm biển số xe theo mã tỉnh
                    5. Sắp xếp biển số xe tăng dần
                    6. Thoát        
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:{
                    System.out.println("==============THÊM BIỂN SỐ XE==============");
                    System.out.print("Số lượng biển số muốn thêm: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    licensePlateArr = new String[n];
                    for (int i = 0; i < licensePlateArr.length; i++) {
                        while (true){
                            System.out.printf("Nhập biển số cho xe thứ %d (30F-123.45): ", i+1);
                            String input = scanner.nextLine();
                            if(input.matches(regex)){
                                licensePlateArr[i] = input;
                                break;
                            }
                            System.out.println("Định dạng biển số không hợp lệ");
                        }

                    }
                    break;
                }
                case 2:{
                    System.out.println("==============DANH SÁCH BIỂN SỐ ĐÃ THÊM==============");
                    if(licensePlateArr == null){
                        System.out.println("Chưa có biển nào được thêm!");
                        break;
                    }
                    for (int i = 0; i < licensePlateArr.length ; i++) {
                        System.out.printf("%s%n", licensePlateArr[i]);
                    }
                    break;
                }
                case 3:{
                    boolean flag = false;
                    int index = -1;
                    if(licensePlateArr == null){
                        System.out.println("Chưa có biển nào được thêm!");
                        break;
                    }
                    System.out.print("Nhập biển số xe cần tìm kiếm: ");
                    String value = scanner.nextLine();
                    for (int i = 0; i < licensePlateArr.length; i++) {
                        if(Objects.equals(licensePlateArr[i], value)){
                            flag = true;
                            index = i;
                            break;
                        }
                    }
                    if(flag){
                        System.out.printf("Đã tìm thấy biển số %s ở vị trí thứ %d trong danh sách!%n", value, index);
                    } else {
                        System.out.println("Không tìm thấy biển số cần tìm!");
                    }
                    break;
                }
                case 4:{
                    int count = 0, index = 0;
                    if(licensePlateArr == null){
                        System.out.println("Chưa có biển nào được thêm!");
                        break;
                    }
                    System.out.print("Nhập mã tỉnh cần tìm biển số: ");
                    String input = scanner.nextLine();
                    for (int i = 0; i < licensePlateArr.length; i++) {
                        if(licensePlateArr[i].substring(0,2).equals(input)){
                            count+=1;
                        }
                    }
                    String[] result = new String[count];
                    for (int j = 0; j < licensePlateArr.length; j++) {
                        if(licensePlateArr[j].substring(0,2).equals(input)){
                            result[index] = licensePlateArr[j];
                            index++;
                        }
                    }
                    System.out.println("Các biển số của tỉnh cần tìm:");
                    for (String elements : result){
                        System.out.printf("%s%n", elements);
                    }
                    break;
                }
                case 5:{
                    System.out.println("=====================SẮP XẾP BIỂN SỐ TĂNG DẦN====================");
                    if(licensePlateArr == null){
                        System.out.println("Chưa có biển nào được thêm!");
                        break;
                    }
                    for (int i = 0; i < licensePlateArr.length - 1; i++) {
                        for (int j = i+1; j < licensePlateArr.length; j++) {
                            if(licensePlateArr[i].compareTo(licensePlateArr[j]) > 0){
                                String temp = licensePlateArr[i];
                                licensePlateArr[i] = licensePlateArr[j];
                                licensePlateArr[j] = temp;
                            }
                        }
                    }
                    for (String elements : licensePlateArr){
                        System.out.printf("%s%n", elements);
                    }
                    break;
                }
                case 6:{
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while (true);
    }
}