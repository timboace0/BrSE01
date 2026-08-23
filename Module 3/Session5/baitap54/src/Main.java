import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập địa chỉ email: ");
        String input = scanner.nextLine();
        if(isEmailValid(input)){
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
    }

    public static boolean isEmailValid(String email){
        String regex = "^[A-Za-z0-9._]+@[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,6}$";
        return Pattern.matches(regex, email.trim());
    }
}