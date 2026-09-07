public class DebitCard extends PaymentMethod {

    public DebitCard() {
    }

    public DebitCard(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.01;
    }

    @Override
    public double processPayment() {
        return amount + calculateFee();
    }

    @Override
    public String processPayment(String currency) {
        return processPayment() + " " + currency;
    }
}