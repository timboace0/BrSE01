public class Developer extends Employee {
    private String programmingLanguage;

    public Developer() {
    }

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        return "Tên: " + getName()
                + ", ID: " + getId()
                + ", Lương cơ bản: " + getSalary()
                + ", Ngôn ngữ: " + programmingLanguage;
    }
}