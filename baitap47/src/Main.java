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
        findDuplicateElement(arr);
    }

    public static void findDuplicateElement(int[] arr){

        if(arr.length == 0){
            System.out.println("Mảng không hợp lệ");
            return;
        }

        int[] newArr = new int[arr.length];
        int count = 0;

        for(int i = 0; i < arr.length; i++){

            int check = 0;

            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    check++;
                }
            }

            if(check == 1){
                newArr[count] = arr[i];
                count++;
            }
        }

        if(count == 0){
            System.out.println("Không có phần tử nào duy nhất trong mảng");
            return;
        }

        for(int i = 0; i < count; i++){
            System.out.print(newArr[i] + " ");
        }
    }
}