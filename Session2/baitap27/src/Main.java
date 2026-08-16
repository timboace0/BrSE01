import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int canh1,canh2,canh3;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập cạnh 1 của tam giác: ");
        canh1 = sc.nextInt();
        System.out.print("Nhập cạnh 2 của tam giác: ");
        canh2 = sc.nextInt();
        System.out.print("Nhập cạnh 3 của tam giác: ");
        canh3 = sc.nextInt();

        if (canh1 + canh2 > canh3 &&
                canh1 + canh3 > canh2 &&
                canh2 + canh3 > canh1) {

            if (canh1 == canh2 && canh2 == canh3) {
                System.out.println("Tam giác đều");

            } else if (canh1 == canh2 || canh1 == canh3 || canh2 == canh3) {
                System.out.println("Tam giác cân");

            } else if (canh1 * canh1 == canh2 * canh2 + canh3 * canh3 ||
                    canh2 * canh2 == canh1 * canh1 + canh3 * canh3 ||
                    canh3 * canh3 == canh1 * canh1 + canh2 * canh2) {
                System.out.println("Tam giác vuông");

            } else {
                System.out.println("Tam giác thường");
            }

        } else {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }
    }
}