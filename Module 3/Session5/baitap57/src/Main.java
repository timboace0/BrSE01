import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Nhập vào số nguyên n: ");
        int n = scanner.nextInt();

        String characters =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < n; i++){
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        System.out.println("chuỗi ngẫu nhiên: " + result);
    }
}