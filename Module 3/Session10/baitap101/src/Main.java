import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        String name;
        int age = 0;
        double avg = 0;

        String choice;
        do {

            do {
                System.out.print("Nhập tên sinh viên: ");
                name = scanner.nextLine();

                if (name.isEmpty()) {
                    System.out.println("Vui lòng không để trống !");
                }

            } while (name.isEmpty());


            boolean validAge = false;

            do {
                try {
                    System.out.print("Nhập tuổi sinh viên: ");
                    String ageInput = scanner.nextLine();

                    if (ageInput.isEmpty()) {
                        System.out.println("Vui lòng không bỏ trống !");
                    } else {
                        age = Integer.parseInt(ageInput);

                        if (age >= 0) {
                            validAge = true;
                        } else {
                            System.out.println("Vui lòng nhập số nguyên >= 0 !");
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số nguyên >= 0 !");
                }


            } while (!validAge);

            boolean validScore = false;

            do {
                try {
                    System.out.print("Nhập điểm trung bình sinh viên: ");
                    String scoreInput = scanner.nextLine();

                    if (scoreInput.isEmpty()) {
                        System.out.println("Vui lòng không bỏ trống !");
                    } else {
                        avg = Double.parseDouble(scoreInput);

                        if (avg >= 0) {
                                validScore = true;
                        } else {
                            System.out.println("Vui lòng nhập số thực >= 0 !");
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số thực >= 0 !");
                }


            } while (!validScore);


            Student student = new Student(name, age, avg);

            students.add(student);

            System.out.print("Bạn có muốn thêm sinh viên khác (y/n)?");
            choice = scanner.nextLine();

        } while (choice.equalsIgnoreCase("y"));

        System.out.println();
        System.out.println("Danh sách sinh viên:");

        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}