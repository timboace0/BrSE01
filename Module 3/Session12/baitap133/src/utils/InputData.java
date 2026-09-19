package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputData {
    public static double getDouble(Scanner scanner, String suggestion) {
        while (true) {
            try {
                System.out.print(suggestion);
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ!");
            }
        }
    }

    public static String getString(Scanner scanner, String suggestion){
        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            if(!input.isEmpty()){
                return input;
            }
            System.out.println("Vui lòng nhập giá trị hợp lệ!");
        } while (true);
    }

    public static Integer getInt(Scanner scanner, String suggestion){
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

    public static LocalDate getDate(Scanner scanner, String suggestion){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input,dtf);
            } catch (DateTimeParseException e){
                System.out.println("Ngày không hợp lệ! Nhập đúng định dạng dd/MM/yyyy");
            }
        } while(true);
    }

    public static Float getFloat(Scanner scanner, String suggestion){
        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập đúng định dạng!");
            }
        } while(true);
    }

}
