//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PaymentMethod creditCard = new CreditCard(1000);
        PaymentMethod debitCard = new DebitCard(1000);
        PaymentMethod cash = new Cash(1000);

        System.out.println("CREDIT CARD:");
        System.out.println("Phí: " + creditCard.calculateFee());
        System.out.println("Tổng tiền: " + creditCard.processPayment());
        System.out.println("Thanh toán: " + creditCard.processPayment("USD"));

        System.out.println();

        System.out.println("DEBIT CARD:");
        System.out.println("Phí: " + debitCard.calculateFee());
        System.out.println("Tổng tiền: " + debitCard.processPayment());
        System.out.println("Thanh toán: " + debitCard.processPayment("USD"));

        System.out.println();

        System.out.println("CASH:");
        System.out.println("Phí: " + cash.calculateFee());
        System.out.println("Tổng tiền: " + cash.processPayment());
        System.out.println("Thanh toán: " + cash.processPayment("USD"));
    }

}