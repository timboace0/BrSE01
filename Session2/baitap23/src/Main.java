import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào 1 số nguyên dương: ");
        input = sc.nextInt();
        if(input <= 0){
            System.err.println("Số nhập vào không hợp lệ");
            return;
        }
        int sum = 0;
        for (int i = 1; i <= input ; i++) {

            sum+= i;
        }
        System.out.printf("Tổng các số từ 1 đến %d là: %d", input, sum);

    }
}