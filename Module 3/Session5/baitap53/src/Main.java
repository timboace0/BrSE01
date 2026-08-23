import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Mời nhập: ");
       String input = scanner.nextLine();
       String newStr = input.replaceAll("[0-9]","*");
        System.out.printf("%s",newStr);
    }
}