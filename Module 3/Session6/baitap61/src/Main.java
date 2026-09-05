import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, passed = 0, failed = 0, excellent = 0;
        double[] arrScore = null;
        String[] arrName = null;
        double avgScore = 0.0, maxScore = 0.0, minScore = Double.MAX_VALUE;
        do {
            System.out.println("""
                    ******************QUẢN LÝ ĐIỂM SV****************
                    
                    1. Nhập danh sách điểm sinh viên
                    2. In danh sách điểm
                    3. Tính điểm trung bình của các sinh viên
                    4. Tìm điểm cao nhất và thấp nhất
                    5. Đếm số lượng sinh viên đạt và trượt
                    6. Sắp xếp điểm tăng dần
                    7. Thống kê số lượng sinh viên giỏi và xuất sắc
                    8. Thoát
                    """);
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1: {
                    System.out.print("Chọn số lượng sinh viên muốn nhập điểm: ");
                    int i = Integer.parseInt(scanner.nextLine());
                    arrScore = new double[i];
                    arrName = new String[i];
                    for (int j = 0; j < arrScore.length; j++) {
                        System.out.printf("Nhập tên cho sinh viên thứ %d: ", j+1);
                        arrName[j] = scanner.nextLine();
                        System.out.printf("Nhập điểm cho sinh viên thứ %d: ", j+1);
                        arrScore[j] = Double.parseDouble(scanner.nextLine());
                    }
                    break;
                }
                case 2: {
                    System.out.println("=================DANH SÁCH ĐIỂM SINH VIÊN=================");
                    if (arrScore == null){
                        System.out.println("Chưa có dữ liệu sinh viên!");
                        break;
                    }
                    for (int i = 0; i < arrScore.length; i++) {
                        System.out.printf("%s: %.2f%n", arrName[i], arrScore[i]);
                    }
                    break;
                }
                case 3: {
                    System.out.println("=================ĐIỂM TRUNG BÌNH CÁC SINH VIÊN=================");
                    if (arrScore == null) {
                        System.out.println("Chưa có dữ liệu sinh viên!");
                        break;
                    }
                    for (int i = 0; i < arrScore.length; i++) {
                        avgScore += arrScore[i];
                    };
                    avgScore = avgScore / arrScore.length;
                    System.out.printf("Điểm trung bình của %d sinh viên là: %.2f%n", arrScore.length, avgScore);
                    break;
                }
                case 4: {
                    System.out.println("=================ĐIỂM CAO NHẤT / THẤP NHẤT SINH VIÊN=================");
                    if (arrScore == null) {
                        System.out.println("Chưa có dữ liệu sinh viên!");
                        break;
                    }
                    for (int i = 0; i < arrScore.length; i++) {
                        if(arrScore[i] > maxScore){
                            maxScore = arrScore[i];
                        }
                        if(arrScore[i] < minScore){
                            minScore = arrScore[i];
                        }
                    };
                    System.out.printf("Điểm sinh viên thấp nhất: %.2f%n", minScore);
                    System.out.printf("Điểm sinh viên cao nhất: %.2f%n", maxScore);
                    break;
                }
                case 5: {
                    if (arrScore == null) {
                        System.out.println("Chưa có dữ liệu sinh viên!");
                        break;
                    }
                    for(int i = 0; i < arrScore.length; i++) {
                        if(arrScore[i] >= 5){
                            passed += 1;
                        } else {
                            failed += 1;
                        }
                    }
                    System.out.printf("Số lượng sinh viên đạt: %d%n", passed);
                    System.out.printf("Số lượng sinh viên trượt: %d%n", failed);
                    break;
                }
                case 6: {
                    if (arrScore == null) {
                        System.out.println("Chưa có dữ liệu sinh viên!");
                        break;
                    }
                    System.out.println("=================ĐIỂM SINH VIÊN THEO THỨ TỰ TĂNG DẦN=================");
                    for (int i = 0; i < arrScore.length - 1; i++) {
                        for (int j = i+1; j < arrScore.length; j++) {
                            if(arrScore[i] > arrScore[j]){
                                double temp = arrScore[i];
                                String temp2 = arrName[i];
                                arrScore[i] = arrScore[j];
                                arrName[i] = arrName[j];
                                arrScore[j] = temp;
                                arrName[j] = temp2;
                            }
                        }
                    }
                    for (int k = 0; k < arrName.length; k++){
                        System.out.printf("%s : %.2f%n", arrName[k], arrScore[k]);
                    }
                    break;
                }
                case 7: {
                    if (arrScore == null) {
                        System.out.println("Chưa có dữ liệu sinh viên!");
                        break;
                    }
                    for(int i = 0; i < arrScore.length; i++) {
                        if(arrScore[i] >= 8){
                            excellent += 1;
                        }
                    }
                    System.out.printf("Số lượng sinh viên giỏi và xuất sắc: %d%n", excellent);
                    break;
                }
                case 8: {
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while(true);
    }
}