import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
    static List<User> userList = new LinkedList<>();
    static String name,email,phone;
    public static void addUser(Scanner scanner){
        do {
            System.out.print("Nhập họ tên: ");
            name = scanner.nextLine();
            if (name.isEmpty()){
                System.out.println("Ko được để trống");
            }
        } while(name.isEmpty());

        do {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            if (email.isEmpty()){
                System.out.println("Ko được để trống");
            }
        } while(email.isEmpty());

        do {
            System.out.print("Nhập số điện thoại: ");
            phone = scanner.nextLine();
            if (phone.isEmpty()){
                System.out.println("Ko được để trống");
            }
        } while(phone.isEmpty());

        User user = new User(name,email,phone);
        userList.add(user);
        System.out.println("Thêm người dùng thành công");
    }

    public static void deleteUser(Scanner scanner){
        boolean flag = false;
        System.out.print("Nhập email người dùng để xóa: ");
        String value = scanner.nextLine();
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getEmail().toLowerCase().equalsIgnoreCase(value)){
                userList.remove(userList.get(i));
                flag = true;
                System.out.println("Xóa người dùng thành công!");
                break;
            }
        }
        if(!flag){
            System.out.println("Ko tìm thấy email người dùng");
        }
    }

    public static void displayUser(){
        for (User user : userList){
            System.out.printf("Tên người dùng: %-15s | Email: %-15s | Số điện thoại: %-15s%n", user.getName(), user.getEmail(), user.getPhoneNumber());
        }
    }
}
