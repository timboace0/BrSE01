import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        float width, height, area, circumference;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều rộng hcn:");
        width = sc.nextFloat();
        System.out.println("Nhập chiều cao hcn:");
        height = sc.nextFloat();

        area = width * height;
        circumference = 2 * (width + height);

        System.out.printf("Diện tích: %.2f\n Chu vi: %.2f", area, circumference);
    }
}