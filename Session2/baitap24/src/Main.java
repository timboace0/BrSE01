import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int age = 0;
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.print("Nhập vào số tuổi của bạn: ");
            String input = sc.nextLine();

            if (!input.isEmpty()) {
                try {
                    age = Integer.parseInt(input);

                    if (age > 0) {
                        break;
                    }
                } catch (NumberFormatException e) {
                }
            }
            System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0");

        }
        System.out.printf("Tuổi của bạn là %d !", age);
    }
}