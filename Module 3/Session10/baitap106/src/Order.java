public class Order {
    private String orderCode;
    private String customerName;

    public Order(String orderCode, String customerName) {
        this.orderCode = orderCode;
        this.customerName = customerName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Mã đơn hàng: " + orderCode + ", Tên khách hàng: " + customerName;
    }
}
