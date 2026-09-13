import java.util.ArrayList;
import java.util.List;

public class InvoiceManager implements IManage<Invoice>{
    private List<Invoice> invoiceList = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        invoiceList.add(item);
    }

    @Override
    public void update(int index, Invoice item) {
        invoiceList.set(index, item);
    }

    @Override
    public void delete(int index) {
        invoiceList.remove(index);
    }

    @Override
    public void display() {
        if (invoiceList.isEmpty()) {
            System.out.println("Danh sách hóa đơn đang trống!");
            return;
        }

        for (Invoice invoice : invoiceList) {
            System.out.println(invoice);
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean isInvoiceCodeExist(String invoiceCode) {
        for (Invoice invoice : invoiceList) {
            if (invoice.getInvoiceCode().equalsIgnoreCase(invoiceCode)) {
                return true;
            }
        }
        return false;
    }

    public Invoice getInvoice(int index) {
        return invoiceList.get(index);
    }
}
