import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập văn bản: ");
        String text = scanner.nextLine();

        if (text.isEmpty()) {
            System.out.println("Không có văn bản để xử lý.");
            return;
        }

        extractNumbers(text);

        text = removeSpecialCharacters(text);

        text = normalizeText(text);


        System.out.println("Văn bản sau khi chuẩn hóa: " + text);
    }

    public static String removeSpecialCharacters(String text) {
        return text.replaceAll("[^a-zA-Z\\s]", "");
    }

    public static String normalizeText(String text) {
        text = text.toLowerCase();
        text = text.trim();
        text = text.replaceAll("\\s+", " ");

        return text;
    }

    public static void extractNumbers(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        System.out.print("Các số trong văn bản: [");

        boolean first = true;

        while (matcher.find()) {
            if (!first) {
                System.out.print(", ");
            }

            System.out.print(matcher.group());
            first = false;
        }

        System.out.println("]");
    }
}