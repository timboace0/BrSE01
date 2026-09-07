//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,3);

        Fraction sum = f1.add(f2);
        Fraction sub = f1.subtract(f2);
        Fraction mul = f1.multiply(f2);
        Fraction div = f1.divide(f2);

        sum.simplify();
        sub.simplify();
        mul.simplify();
        div.simplify();

        System.out.println("Cộng: " + sum);
        System.out.println("Trừ: " + sub);
        System.out.println("Nhân: " + mul);
        System.out.println("Chia: " + div);
    }
}