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
        System.out.print("Các số Happy nhỏ hơn hoặc bằng " + input + " là: ");
        for (int number = 1; number <= input; number++) {

            int current = number;

            while (current != 1 && current != 4) {
                int sum = 0;
                int temp = current;

                while (temp > 0) {
                    int digit = temp % 10;
                    sum += digit * digit;
                    temp = temp / 10;
                }

                current = sum;
            }

            if (current == 1) System.out.print(number + ", ");
        }
    }
}