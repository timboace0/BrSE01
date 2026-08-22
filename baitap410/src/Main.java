import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = {};

        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ MẢNG =====");
            System.out.println("1. Thêm phần tử");
            System.out.println("2. Xóa phần tử");
            System.out.println("3. Hiển thị mảng");
            System.out.println("4. Sắp xếp giảm dần");
            System.out.println("5. Tìm kiếm phần tử");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Nhập phần tử cần thêm: ");
                    int value = scanner.nextInt();

                    arr = addElement(arr, value);

                    System.out.println("Đã thêm phần tử.");
                    break;

                case 2:
                    if (arr.length == 0) {
                        System.out.println("Mảng đang rỗng.");
                        break;
                    }

                    displayArray(arr);

                    System.out.print("Nhập index cần xóa: ");
                    int index = scanner.nextInt();

                    arr = deleteElement(arr, index);

                    break;

                case 3:
                    displayArray(arr);
                    break;

                case 4:
                    sortDescending(arr);

                    System.out.println("Đã sắp xếp giảm dần.");
                    displayArray(arr);

                    break;

                case 5:
                    if (arr.length == 0) {
                        System.out.println("Mảng đang rỗng.");
                        break;
                    }

                    System.out.print("Nhập giá trị cần tìm: ");
                    int searchValue = scanner.nextInt();

                    int result = searchElement(arr, searchValue);

                    if (result == -1) {
                        System.out.println("Không tìm thấy phần tử.");
                    } else {
                        System.out.println(
                                "Tìm thấy " + searchValue +
                                        " tại index: " + result
                        );
                    }

                    break;

                case 6:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 6);
    }

    public static int[] addElement(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[newArr.length - 1] = value;

        return newArr;
    }

    public static int[] deleteElement(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Index không hợp lệ");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j] = arr[i];
                j++;
            }
        }

        return newArr;
    }

    public static void displayArray(int[] arr) {
        System.out.print("Mảng: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void sortDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    public static int searchElement(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }




}