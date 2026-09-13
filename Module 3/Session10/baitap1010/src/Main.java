import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> romanMap = new LinkedHashMap<>();

        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        do {
            System.out.print("Nhập số nguyên dương từ 1 đến 3999: ");

            int number;

            try {
                number = Integer.parseInt(scanner.nextLine());

                if (number < 1 || number > 3999) {
                    System.out.println("Vui lòng nhập số từ 1 đến 3999!");
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
                continue;
            }

            StringBuilder result = new StringBuilder();

            for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
                int value = entry.getKey();
                String symbol = entry.getValue();

                while (number >= value) {
                    number -= value;
                    result.append(symbol);
                }
            }

            System.out.println("Số La Mã: " + result);

            break;

        } while (true);
    }
}