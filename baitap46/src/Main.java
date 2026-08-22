import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size, searchValue;
        System.out.print("Nhập kích thước của mảng: ");
        size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("%n arr[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
        System.out.print("Nhập số cần tìm: ");
        searchValue = scanner.nextInt();
        selectionSort(arr);
        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần: "+ Arrays.toString(arr));
        System.out.printf("%n Tìm kiếm tuyến tính: Phần tử %d tìm thấy tại địa chỉ số: %d", searchValue, linearSearch(arr,searchValue));
        System.out.printf("%n Tìm kiếm nhị phân: Phần tử %d tìm thấy tại địa chỉ số: %d", searchValue, binarySearch(arr,searchValue));
    }

    public static int linearSearch(int[] arr, int searchValue){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == searchValue){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int searchValue) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == searchValue){
                return mid;
            }
            if(arr[mid] > searchValue){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length -1; i++){
            int maxValue = arr[i];
            int maxIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] > maxValue){
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


