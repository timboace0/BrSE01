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
        for(int i = 0; i < size; i++){
            System.out.printf("%n arr[%d] = ", i);
            arr[i] = scanner.nextInt();
        }

        System.out.print("Mảng trước khi sắp xếp: ");
        System.out.print(Arrays.toString(arr));
        selectionSort(arr);
        System.out.print("\nMảng sau khi sắp xếp theo thứ tự giảm dần: ");
        System.out.print(Arrays.toString(arr));
        System.out.printf("\nPhần tử lớn nhất trong mảng là: %d", arr[0]);
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int maxValue = arr[i];
            int maxIndex = i;

            for(int j = i + 1; j < arr.length ;j++){
                if(maxValue < arr[j]){
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }

            if(maxIndex != i){
                arr[maxIndex] = arr[i];
                arr[i] = maxValue;
            }
        }
    }
}