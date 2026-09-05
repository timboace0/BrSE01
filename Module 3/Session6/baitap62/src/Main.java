import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String fullName = "";
        String email = "";
        String phone = "";
        String pwd = "";

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^(03|05|07|08|09)\\d{8}$";
        String pwdRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{8,}$";
        do {
            System.out.println("""
                    ******************QUẢN LÝ NGƯỜI DÙNG****************
                    
                    1.Nhập thông tin người dùng
                    2. Chuẩn hóa họ tên
                    3. Kiểm tra email hợp lệ
                    4. Kiểm tra số điện thoại hợp lệ
                    5. Kiểm tra mật khẩu hợp lệ
                    6. Thoát
                    
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:{
                    System.out.println("================NHẬP THÔNG TIN NGƯỜI DÙNG================");
                    System.out.print("Nhập họ và tên: ");
                    fullName = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    email = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    phone = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    pwd = scanner.nextLine();
                    break;
                }
                case 2:{
                    System.out.printf("Họ và tên người dùng sau khi được chuẩn hóa: %s%n", normalizeName(fullName));
                    break;
                }
                case 3:{
                    if(email.matches(emailRegex)){
                        System.out.println("Email hợp lệ");
                    } else {
                        System.out.println("Email không hợp lệ");
                    }
                    break;
                }
                case 4:{
                    if(phone.matches(phoneRegex)){
                        System.out.println("Số điện thoại hợp lệ");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ");
                    }
                    break;
                }
                case 5:{
                    if(pwd.matches(pwdRegex)){
                        System.out.println("mật khẩu hợp lệ");
                    } else {
                        System.out.println("mật khẩu không hợp lệ");
                    }
                    break;
                }
                case 6:{
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);

    }

    public static String normalizeName(String name){
      name = name.trim();

      name = name.replaceAll("\\s+", " ");

      String[] words = name.split(" ");
      StringBuilder result = new StringBuilder();

      for(String word : words){
          word = word.toLowerCase();
          word = Character.toUpperCase(word.charAt(0)) + word.substring(1);

          result.append(word).append(" ");
      }
      return result.toString().trim();
    };
}