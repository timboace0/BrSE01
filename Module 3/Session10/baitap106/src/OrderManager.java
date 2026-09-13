import java.util.ArrayList;
import java.util.List;

public class OrderManager implements IManage<Order>{
    private List<Order> orderList = new ArrayList<>();

    @Override
    public void add(Order item) {
        orderList.add(item);
    }

    @Override
    public void update(int index, Order item) {
        orderList.set(index, item);
    }

    @Override
    public void delete(int index) {
        orderList.remove(index);
    }

    @Override
    public void display() {
        if (orderList.isEmpty()) {
            System.out.println("Danh sách đơn hàng đang trống!");
            return;
        }

        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i));
        }
    }

    public int findIndexByOrderCode(String orderCode) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderCode().equalsIgnoreCase(orderCode)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isOrderCodeExist(String orderCode) {
        for (Order order : orderList) {
            if (order.getOrderCode().equalsIgnoreCase(orderCode)) {
                return true;
            }
        }
        return false;
    }

    public Order getOrder(int index) {
        return orderList.get(index);
    }
}
