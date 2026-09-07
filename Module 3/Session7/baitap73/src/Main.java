import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person person1 = new Person();
        System.out.print("Nhập tên cho người thứ 1: ");
        person1.setName(scanner.nextLine());
        System.out.print("Nhập tuổi cho người thứ 1: ");
        person1.setAge(Integer.parseInt(scanner.nextLine()));

        Person person2 = new Person();
        System.out.print("Nhập tên cho người thứ 2: ");
        person2.setName(scanner.nextLine());
        System.out.print("Nhập tuổi cho người thứ 2: ");
        person2.setAge(Integer.parseInt(scanner.nextLine()));

        if (person1.getAge() == person2.getAge()){
            System.out.printf("%s bằng tuổi %s", person1.getName(), person2.getName());
        } else if (person1.getAge() > person2.getAge()){
            System.out.printf("%s lớn tuổi hơn %s", person1.getName(), person2.getName());
        } else {
            System.out.printf("%s nhỏ tuổi hơn %s", person1.getName(), person2.getName());
        }

    }
}