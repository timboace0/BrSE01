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
        bubbleSort(arr);
        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần: "+ Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr){
        boolean needNextPass = true;
        for(int i = 0; i < arr.length - 1 && needNextPass; i++){
            needNextPass = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] < arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}