import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        int sumOdd = 0, sumEven = 0;
        System.out.print("Nhập số hàng: ");
        row = scanner.nextInt();
        System.out.print("Nhập số cột: ");
        col = scanner.nextInt();

        int[][] arr = new int[row][col];

        System.out.println("Nhập các phần tử cho từng mảng (theo từng hàng): ");
        for(int i = 0; i < row; i++){
            System.out.printf("Hàng %d: ", i+1);
            for(int j = 0; j < col; j++){
                arr[i][j] = scanner.nextInt();

                if(arr[i][j] % 2 != 0){
                    sumEven += arr[i][j];
                } else {
                    sumOdd += arr[i][j];
                }
            }
        }

        System.out.printf("Tổng các số chẵn là: %d ", sumOdd);
        System.out.printf("%nTổng các số lẽ là: %d ", sumEven);
    }
}