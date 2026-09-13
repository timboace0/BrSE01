public class Invoice {
    private int id;
    private String invoiceCode;
    private double amount;

    public Invoice(int id, String invoiceCode, double amount) {
        this.id = id;
        this.invoiceCode = invoiceCode;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ID : " + id + " , Mã hóa đơn: " + invoiceCode + ", Số tiền: " + amount;
    }
}