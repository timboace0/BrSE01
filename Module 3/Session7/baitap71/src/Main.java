//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hình chữ nhật 1:");
        Rectangle rectangle1 = new Rectangle();
        rectangle1.display();
        System.out.println();
        System.out.println("Hình chữ nhật 2:");
        Rectangle rectangle2 = new Rectangle(5.0,3.0);
        rectangle2.display();
    }
}