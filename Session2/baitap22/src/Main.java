import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int input;
        System.out.print("Nhập số nguyên (1-7): ");
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        switch (input){
            case 1:
                System.out.println("Chủ nhật");
                break;
            case 2:
                System.out.println("Thứ hai");
                break;
            case 3:
                System.out.println("Thứ ba");
                break;
            case 4:
                System.out.println("Thứ tư");
                break;
            case 5:
                System.out.println("Thứ năm");
                break;
            case 6:
                System.out.println("Thứ sáu");
                break;
            case 7:
                System.out.println("Thứ bảy");
                break;
            default:
                System.out.println("Số nhập vào không hợp lệ");
        }
    }
}