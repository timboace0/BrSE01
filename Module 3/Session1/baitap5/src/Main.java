import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tử số số thứ 1:");
        int tuSo1 = sc.nextInt();
        System.out.print("Nhập mẫu số số thứ 1:");
        int mauSo1 = sc.nextInt();
        System.out.print("Nhập tử số số thứ 2:");
        int tuSo2 = sc.nextInt();
        System.out.print("Nhập mẫu số số thứ 2:");
        int mauSo2 = sc.nextInt();

        int tusoTong = (tuSo1 * mauSo2) + (mauSo1 * tuSo2);
        int mausoTong = mauSo1 * mauSo2;

        System.out.printf("phân số 1: %d/%d, phân số 2: %d/%d \n", tuSo1, mauSo1, tuSo2, mauSo2);
        System.out.printf("kết quả: %d/%d", tusoTong, mausoTong);
    }
}