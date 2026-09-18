package utils;

import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String suggestion){
        do{
            System.out.print(suggestion);
            String input = scanner.nextLine();
            if(!input.isEmpty()){
                return input;
            }
            System.out.println("Vui lòng không bỏ trống!");
        } while (true);
    }

    public static int getInt(Scanner scanner, String suggestion){
        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số nguyên!");
            }

        } while(true);

    }
}
