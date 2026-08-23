import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String input = scanner.nextLine();

        if(input.isEmpty()){
            System.out.println("");
            return;
        }

        StringBuilder result = new StringBuilder();

        int count = 1;

        for(int i = 0; i < input.length(); i++){
             if(i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                 count++;
             } else {
                 result.append(input.charAt(i));
                 result.append(count);
                 count = 1;
             }
        }

        System.out.println("Chuỗi sau khi nén: " + result);
    }
}