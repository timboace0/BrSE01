public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double amount) {
        salary += amount;
    }

    @Override
    public String toString() {
        return "Tên: " + name
                + ", ID: " + id
                + ", Lương: " + salary;
    }
}