import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        while (true) {
            System.out.print("Nhập số nguyên dương N: ");

            if (sc.hasNextInt()) {
                input = sc.nextInt();

                if (input > 0) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Số nhập vào không hợp lệ");
        }

        for (int number = 0; number <= input; number++) {

            int temp = number;
            int k = 0;

            if (number == 0) {
                k = 1;
            } else {
                while (temp > 0) {
                    k++;
                    temp = temp / 10;
                }
            }

            temp = number;
            int sum = 0;

            if (number == 0) {
                sum = 0;
            } else {
                while (temp > 0) {
                    int digit = temp % 10;
                    sum += Math.pow(digit, k);
                    temp = temp / 10;
                }
            }

            if (sum == number) {
                System.out.println(number);
            }
        }
    }
}