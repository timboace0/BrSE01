import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Nhập n =");
        n = scanner.nextInt();

        if(n <= 0){
            System.out.println("Ma trận không hợp lệ");
            return;
        }

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            System.out.printf("Nhập giá trị cho hàng %d:", i+1);
            for(int j = 0; j < n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - 1 - j];
                arr[i][n - 1 - j] = temp;
            }
        }

        System.out.println("Ma trận sau khi xoay 90 độ:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}