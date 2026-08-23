import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập URL: ");
        String url = scanner.nextLine();

        if (checkUrl(url)) {
            String[] parts = url.split("://", 2);

            String protocol = parts[0];
            String domainAndPath = parts[1];

            System.out.println("Giao thức: " + protocol);

            int index = domainAndPath.indexOf("/");

            if (index != -1) {
                System.out.println("Tên miền: " + domainAndPath.substring(0, index));
                System.out.println("Đường dẫn: " + domainAndPath.substring(index));
            } else {
                System.out.println("Tên miền: " + domainAndPath);
                System.out.println("Đường dẫn: Không có");
            }
        } else {
            System.out.println("URL không hợp lệ");
        }


    }

    public static boolean checkUrl(String url){
        String regex = "^(https?)://([^/]+)(/.*)?$";
        return Pattern.matches(regex, url);
    }
}