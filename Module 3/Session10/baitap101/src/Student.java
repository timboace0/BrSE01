public class Student {
    private String name;
    private int age;
    private double averageScore;

    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return "Tên: " + name
                + ", Tuổi: " + age
                + ", Điểm trung bình: " + averageScore;
    }
}
