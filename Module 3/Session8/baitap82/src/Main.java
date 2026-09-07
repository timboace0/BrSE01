//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vehicle car1 = new Car("Toyota", 120);
        Vehicle bike1 = new Bike("Yamaha", 80);
        car1.start();
        car1.displayInfo();
        System.out.println();
        bike1.start();
        bike1.displayInfo();
    }
}