import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Message> messages = new ArrayList<>();

        do {
            System.out.print("Nhập tên người gửi (hoặc 'exit' để thoát): ");
            String sender = scanner.nextLine();
            if(sender.equalsIgnoreCase("exit")){
                System.out.println("Bạn đã thoát chương trình");
                break;
            }
            System.out.print("Nhập nội dung tin nhắn: ");
            String message = scanner.nextLine();
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String currentTime = now.format(dtf);
            messages.add(new Message(sender,message,currentTime));

            System.out.println("Nhập 'history' để xem lịch sử, hoặc 'filter' để lọc tin nhắn theo người gửi, hoặc 'date' để lọc theo ngày: ");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("history")){
                System.out.println("Lịch sử chat: ");
                messages.forEach(m -> System.out.println(m.toString()));
            } else if(input.equalsIgnoreCase("filter")){
                System.out.print("Nhập tên người để lọc: ");
                String name = scanner.nextLine();
                System.out.printf("Tin nhắn từ %s: %n",name);
                messages.stream().filter(m -> m.getSender().equalsIgnoreCase(name)).forEach(m -> System.out.println(m));
            } else if(input.equalsIgnoreCase("date")){
                System.out.print("Nhập ngày (dd/MM/yyyy): ");
                String date = scanner.nextLine();
                System.out.printf("Tin nhắn trong ngày %s: %n",date);
                messages.stream().filter(m -> m.getTimestamp().startsWith(date)).forEach(m -> System.out.println(m));
            }
        } while (true);

    }
}