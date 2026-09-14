import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");

        List<User> users = List.of(u1, u2, u3);

        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );

        LocalDate today = LocalDate.of(2025, 3, 23);

        System.out.println("CÔNG VIỆC QUÁ HẠN VÀ CHƯA HOÀN THÀNH");

        tasks.stream()
                .filter(task -> !task.isCompleted())
                .filter(task -> task.getDueDate().isBefore(today))
                .forEach(task -> System.out.println(task.toDisplayString()));

        long completedCount = tasks.stream()
                .filter(Task::isCompleted)
                .count();

        System.out.println("\nSỐ CÔNG VIỆC ĐÃ HOÀN THÀNH: " + completedCount);

        System.out.println("\nDANH SÁCH NGƯỜI DÙNG");

        users.forEach(user ->
                System.out.println(user.toDisplayString())
        );
    }
}