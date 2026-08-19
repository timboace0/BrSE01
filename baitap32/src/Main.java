import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        double point = 0;
        int totalStudent = 0;
        double totalScore = 0;
        double highestScore = 0;
        double lowestScore = 10;
        double avgScore = 0;
        while(choice != 3) {
            System.out.print("""
                    ***************MENU NHẬP ĐIỂM***************
                    
                    1.  	Nhập điểm học viên
                    
                    2.  	Hiển thị thống kê
                    
                    3.  	Thoát
                    
                    Lựa chọn của bạn:
                    """);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1: {
                    while(point != -1){

                        System.out.print("Hãy nhập điểm số cho sinh viên (nhập -1 để dừng): ");
                        point = Double.parseDouble(scanner.nextLine());
                        if(point > 10 || point < -1){
                            System.err.println("Số điểm nằm ngoài phạm vi yêu câu nhập lại");
                        } else if(point >= 0 && point < 5){
                            System.out.println("Học Lực Yếu");
                            totalStudent += 1;
                            totalScore += point;
                            if(point >= highestScore){
                                highestScore = point;
                            }
                            if(point <= lowestScore){
                                lowestScore = point;
                            }
                        } else if(point >= 5 && point < 7){
                            System.out.println("Học Lực Trung Bình");
                            totalStudent += 1;
                            totalScore += point;
                            if(point >= highestScore){
                                highestScore = point;
                            }
                            if(point <= lowestScore){
                                lowestScore = point;
                            }
                        } else if(point >= 7 && point < 8){
                            System.out.println("Học Lực Khá");
                            totalStudent += 1;
                            totalScore += point;
                            if(point >= highestScore){
                                highestScore = point;
                            }
                            if(point <= lowestScore){
                                lowestScore = point;
                            }
                        } else if(point >= 8 && point < 9){
                            System.out.println("Học Lực Giỏi");
                            totalStudent += 1;
                            totalScore += point;
                            if(point >= highestScore){
                                highestScore = point;
                            }
                            if(point <= lowestScore){
                                lowestScore = point;
                            }
                        } else if(point >= 9){
                            System.out.println("Học Lực Xuất Sắc");
                            totalStudent += 1;
                            totalScore += point;
                            if(point >= highestScore){
                                highestScore = point;
                            }
                            if(point <= lowestScore){
                                lowestScore = point;
                            }
                        }
                        System.out.println("Tổng số học sinh đã nhập: " +totalStudent);
                        System.out.println("Tổng điểm: " +totalScore);
                        System.out.println("Điểm sinh viên cao nhất: " +highestScore);
                        System.out.println("Điểm sinh viên thấp nhất: " +lowestScore);
                    }
                    if (totalStudent > 0){
                        avgScore = totalScore/totalStudent;
                    }
                    break;
                }
                case 2: {
                    if(totalStudent == 0){
                        System.out.print("Chưa có dữ liệu");
                    } else {
                        System.out.println("=============================KẾT QUẢ=========================");
                        System.out.println("Tổng số học sinh đã nhập: " + totalStudent);
                        System.out.println("Điê trung bình: " + avgScore);
                        System.out.println("Điểm cao nhất: " + highestScore);
                        System.out.println("Điểm thấp nhất: " + lowestScore);
                    }
                    break;
                }
                case 3: {
                    System.out.print("Bạn đã thoát chương trình");
                    break;
                }
                default:
                    System.out.print("Lựa chọn không nằm trong danh mục");
            }
        }
    }
}