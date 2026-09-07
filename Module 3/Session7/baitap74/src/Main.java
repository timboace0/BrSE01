import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student1 = new Student("Bob",21,"A1",7.0);
        Student student2 = new Student("Eve",20,"A1",8.0);
        Student student3 = new Student("Mad",18,"A1",5.0);

        Student[] studentList = {student1,student2,student3};

        System.out.print("Nhập điểm min: ");
        double minAvg = Double.parseDouble(scanner.nextLine());
        System.out.println();
        System.out.print("Nhập điểm max: ");
        double maxAvg = Double.parseDouble(scanner.nextLine());

        System.out.printf("Danh sách sinh viên có điểm trung bình từ %.2f đến %.2f %n", minAvg, maxAvg);
        for (int i = 0; i < studentList.length; i++) {
            if(studentList[i].getAvgScore() >= minAvg && studentList[i].getAvgScore() <= maxAvg){
                System.out.printf("Tên: %s, Tuổi: %d, Lớp: %s, Điểm trung bình: %.2f %n", studentList[i].getName(), studentList[i].getAge(), studentList[i].get_class(), studentList[i].getAvgScore());
            }
        }
    }
}