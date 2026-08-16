import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Nhập vào 1 số nguyên: ");
        Scanner sc = new Scanner(System.in);
        int input, sum = 0;
        input = sc.nextInt();
        input = Math.abs(input);
        while (input > 0){
            int i = input % 10;
            sum += i;
            input = input / 10;
        }
        System.out.printf("Tổng của các số là: %d", sum);
    }
}