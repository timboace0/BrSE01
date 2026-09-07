//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("A001",0, "Nguyễn Văn A", "0123456789");
        BankAccount accountB = new BankAccount("B001",0, "Nguyễn Văn B", "0987654321");

        accountA.deposit(1000);

        double transferAmount = 300;
        accountA.withdraw(transferAmount);
        accountB.deposit(transferAmount);

        accountA.displayBalance();
        accountB.displayBalance();
    }
}