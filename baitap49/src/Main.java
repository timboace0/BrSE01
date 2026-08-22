import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        System.out.print("Nhập số phần tử của mảng (n): ");
        size = scanner.nextInt();
        if(size <= 0){
            System.out.println("Mảng không hợp lệ");
            return;
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("%n arr[%d] = ", i);
            arr[i] = scanner.nextInt();
        }

        int currentSum = 0;
        int maxSum = arr[0];

        int tempStart = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {

            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        System.out.println("Tổng lớn nhất: " + maxSum);

        System.out.print("Dãy con có tổng lớn nhất: [");

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);

            if (i < end) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

}