import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Nhập số nguyên (1-12): ");
        Scanner sc = new Scanner(System.in);
        int input;
        input = sc.nextInt();
        switch (input){
            case 1,3,5,7,8,10,12:
                System.out.printf("Tháng %d có 31 ngày.", input);
                break;
            case 4,6,9,11:
                System.out.printf("Tháng %d có 30 ngày.", input);
                break;
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày.");
            default:
                System.out.println("Tháng không hợp lệ.");
        }

    }
}