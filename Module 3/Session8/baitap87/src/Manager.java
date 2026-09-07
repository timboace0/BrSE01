public class Manager extends Employee{
    private double bonus;

    public Manager() {
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Tên: " + getName()
                + ", ID: " + getId()
                + ", Lương cơ bản: " + super.getSalary()
                + ", Bonus: " + bonus
                + ", Tổng lương: " + getSalary();
    }
}


