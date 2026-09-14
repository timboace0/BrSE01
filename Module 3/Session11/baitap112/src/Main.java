import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice",20,8.5),
            new Student("Bob", 21, 7.2),
            new Student("Charlie", 19, 9.0),
            new Student("Jack", 22, 6.8),
            new Student("Emma", 20, 8.0),
            new Student("Frank", 21, 7.5),
            new Student("Grace", 19, 9.2),
            new Student("Henry", 22, 6.5),
            new Student("Ivy", 20, 8.8),
            new Student("David", 21, 7.9)
        );


        students.stream().filter(n -> n.getGrade() > 7.0).forEach(n -> System.out.println(n));
        System.out.println();
        System.out.println("Sắp xếp danh sách theo tên: ");
        students.stream().sorted((s1,s2) -> s1.getName().compareTo(s2.getName())).forEach(s -> System.out.println(s));
    }
}