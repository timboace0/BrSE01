import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order(1, "Quý", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 25)),
                new Order(2, "Lan", LocalDate.of(2025, 3, 21), null),
                new Order(3, "Minh", LocalDate.of(2025, 3, 22), LocalDate.of(2025, 3, 23)),
                new Order(4, "Huyền", LocalDate.of(2025, 3, 23), null),
                new Order(5, "Việt", LocalDate.of(2025, 3, 23), LocalDate.of(2025, 3, 30))
        );

        System.out.println("DANH SÁCH ĐƠN HÀNG ĐÃ GIAO");
        orders.stream()
                .filter(order -> order.getDeliveryDate().isPresent())
                .forEach(order -> System.out.println(order.toDisplayString()));

        System.out.println("\nDANH SÁCH ĐƠN HÀNG CHƯA GIAO");
        orders.stream()
                .filter(order -> order.getDeliveryDate().isEmpty())
                .forEach(order -> System.out.println(order.toDisplayString()));

        LocalDate startDate = LocalDate.of(2025, 3, 17);
        LocalDate endDate = LocalDate.of(2025, 3, 23);

        long count = orders.stream()
                .filter(order -> order.getDeliveryDate().isPresent())
                .filter(order -> {
                    LocalDate deliveryDate = order.getDeliveryDate().get();
                    return !deliveryDate.isBefore(startDate)
                            && !deliveryDate.isAfter(endDate);
                })
                .count();

        System.out.println("\nSố đơn hàng đã giao từ "
                + startDate + " đến " + endDate + ": " + count);

        System.out.println("\nDANH SÁCH TẤT CẢ ĐƠN HÀNG");
        System.out.printf("%-3s | %-10s | %-12s | %-12s%n",
                "ID", "Tên KH", "Ngày đặt", "Ngày giao");

        orders.forEach(order -> System.out.println(order.toDisplayString()));
    }
}