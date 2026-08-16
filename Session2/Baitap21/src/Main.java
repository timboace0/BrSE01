import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 số nguyên: ");
        input = sc.nextInt();
        if(input == 0){
            System.out.println("Số không phải chẵn cũng không phải lẻ");
        } else if(input % 2 == 0) {
            System.out.printf("Số %d là số chẵn", input);
        } else {
            System.out.printf("Số %d là số lẻ", input);
        }
    }
}