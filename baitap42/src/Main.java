import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size, sum = 0;
        System.out.print("Nhập kích thước của mảng: ");
        size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("%n arr[%d] = ", i);
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        System.out.printf("Tổng các phần tử trong mảng là: %d", sum);

    }
}