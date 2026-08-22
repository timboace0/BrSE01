import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        System.out.print("Nhập kích thước của mảng: ");
        size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("%n arr[%d] = ", i);
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mảng trước khi đảo ngược: "+ Arrays.toString(arr));
        reverseArray(arr);
    }

    public static void reverseArray(int[] arr){
        if(arr.length == 0){
            System.out.println("Kích thước rỗng");
            return;
        }
        for (int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println("Mảng sau khi đảo ngược: "+ Arrays.toString(arr));
    }
}

