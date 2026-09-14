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
        List<Event> events = new ArrayList<>();
        String name;
        do {

        do {
            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            name = scanner.nextLine();
            if(name.equalsIgnoreCase("exit")){
                System.out.println("Danh sách sự kiện: ");
                events.forEach(System.out::println);
                System.exit(0);
            }
            if(name.isEmpty()){
                System.out.println("Ko được để trống");
            }
        } while(name.isEmpty());

        String startDate,endDate;
        LocalDateTime startDateTime, endDateTime;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        do {
            System.out.print("Nhập ngày bắt đầu (dd-MM-yyyy HH:mm): ");
            startDate = scanner.nextLine();

            try {
                startDateTime = LocalDateTime.parse(startDate, dtf);
                break;
            } catch (Exception e){
                System.out.println("Nhập sai định dạng! vui lòng nhập lại");
            }

        }while(true);

        do {
            System.out.print("Nhập ngày kết thúc (dd-MM-yyyy HH:mm): ");
            endDate = scanner.nextLine();

            try {
                endDateTime = LocalDateTime.parse(endDate, dtf);
                break;
            } catch (Exception e){
                System.out.println("Nhập sai định dạng! vui lòng nhập lại");
            }

        }while(true);

            events.add(new Event(name,startDateTime,endDateTime));

        } while (true);

    }
}