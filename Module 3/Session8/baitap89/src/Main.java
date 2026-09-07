public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage();

        Car electricCar = new ElectricCar("Mitsubishi Xpander", 2024, 40000);
        Car gasCar = new GasCar("Toyota Innova", 2023, 30000);

        garage.addCar(electricCar);
        garage.addCar(gasCar);

        System.out.println("KHỞI ĐỘNG");
        garage.startAll();

        System.out.println();

        System.out.println("DỪNG XE");
        garage.stopAll();

        System.out.println();

        System.out.println("NẠP NHIÊN LIỆU");
        garage.refuelAll();
    }
}