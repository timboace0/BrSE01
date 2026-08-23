import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi văn bản: ");
        String input = scanner.nextLine();

        System.out.print("Nhập từ cần tìm: ");
        String searchValue = scanner.nextLine();

        if(input.contains(searchValue)){
            System.out.printf("Từ %s xuất hiện tại vị trí thứ %d trong chuỗi.", searchValue, input.indexOf(searchValue));
        } else {
            System.out.printf("Không tìm thấy từ %s trong chuỗi.", searchValue);
        }

    }
}