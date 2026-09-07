//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Khang", 1, 1000);

        Manager manager = new Manager("Nam", 2, 2000, 500);

        Developer developer = new Developer("An", 3, 1800, "Java");

        System.out.println(employee);
        System.out.println("Lương: " + employee.getSalary());

        System.out.println();

        System.out.println(manager);
        System.out.println("Lương: " + manager.getSalary());

        System.out.println();

        System.out.println(developer);
        System.out.println("Lương: " + developer.getSalary());

        System.out.println();

        employee.increaseSalary(500);

        System.out.println("Sau khi tăng lương:");
        System.out.println(employee);
    }
    
}