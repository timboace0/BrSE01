import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Nhập vào 1 số (100-999): ");
        Scanner sc = new Scanner(System.in);
        int input;
        input = sc.nextInt();
        if (input < 100 || input > 999) {
            System.out.println("Số nhập vào không hợp lệ");
        }

        int hundreds = input / 100;
        int tens = (input / 10) % 10;
        int units = input % 10;
        switch (hundreds) {
            case 1:
                System.out.print("Một trăm ");
                break;
            case 2:
                System.out.print("Hai trăm ");
                break;
            case 3:
                System.out.print("Ba trăm ");
                break;
            case 4:
                System.out.print("Bốn trăm ");
                break;
            case 5:
                System.out.print("Năm trăm ");
                break;
            case 6:
                System.out.print("Sáu trăm ");
                break;
            case 7:
                System.out.print("Bảy trăm ");
                break;
            case 8:
                System.out.print("Tám trăm ");
                break;
            case 9:
                System.out.print("Chín trăm ");
                break;
        }

        switch (tens) {
            case 0:
                if (units != 0) {
                    System.out.print("lẻ ");
                }
                break;
            case 1:
                System.out.print("mười ");
                break;
            case 2:
                System.out.print("hai mươi ");
                break;
            case 3:
                System.out.print("ba mươi ");
                break;
            case 4:
                System.out.print("bốn mươi ");
                break;
            case 5:
                System.out.print("năm mươi ");
                break;
            case 6:
                System.out.print("sáu mươi ");
                break;
            case 7:
                System.out.print("bảy mươi ");
                break;
            case 8:
                System.out.print("tám mươi ");
                break;
            case 9:
                System.out.print("chín mươi ");
                break;
        }

        switch (units) {
            case 1:
                System.out.print("một");
                break;
            case 2:
                System.out.print("hai");
                break;
            case 3:
                System.out.print("ba");
                break;
            case 4:
                System.out.print("bốn");
                break;
            case 5:
                System.out.print("năm");
                break;
            case 6:
                System.out.print("sáu");
                break;
            case 7:
                System.out.print("bảy");
                break;
            case 8:
                System.out.print("tám");
                break;
            case 9:
                System.out.print("chín");
                break;
        }
    }
}