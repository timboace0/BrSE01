package utils;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String suggestion){
        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            if(!input.isEmpty()){
                return input;
            }
            System.out.println("Không được để trống!");
        } while (true);
    }

    public static Integer getInt(Scanner scanner, String suggestion){
        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập đúng định dạng số!");
            }
        } while (true);
    }

    public static Float getFloat(Scanner scanner, String suggestion){
        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập đúng định dạng số thực!");
            }
        } while (true);
    }

    public static Boolean getBoolean(Scanner scanner, String suggestion){
        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            try {
                return Boolean.parseBoolean(input);
            } catch (InputMismatchException e){
                System.out.println("Vui lòng nhập true hoặc false!");
            }
        } while (true);
    }
}
