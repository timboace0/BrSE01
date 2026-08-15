import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập bán kính hình tròn: ");
        double banKinh = sc.nextDouble();

        double dienTich = Math.PI * banKinh * banKinh;

        System.out.printf("Diện tích: %.2f", dienTich);
    }
}