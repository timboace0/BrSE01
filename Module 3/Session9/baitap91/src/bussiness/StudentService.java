package bussiness;

import model.Student;

import java.util.Scanner;

public class StudentService {
    public static Student[] students = new Student[100];
    public static int currentIndex = 0;

    public static void displayListStudents(){
        if(currentIndex == 0){
            System.out.println("Danh sách đang trống!");
            return;
        }
        System.out.println("===============DANH SÁCH SINH VIÊN================");
        for(int i = 0; i < currentIndex; i++){
            students[i].displayData();
        }
    }

    public static int checkIdExist(int id){
        for(int i = 0; i < currentIndex; i++){
            if(students[i].getId() == id){
                return i;
            }
        }
        return -1;
    }

    public static void addStudent(Scanner scanner){
        Student newStudent = new Student();
        newStudent.inputData(scanner);
        students[currentIndex] = newStudent;
        currentIndex++;
    }

    public static void updateStudent(Scanner scanner){
        System.out.print("Nhập vào ID sinh viên cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        int indexExist = checkIdExist(id);
        if(indexExist == -1){
            System.out.println("Không tìm thấy ID sinh viên");
        } else {
            students[indexExist].inputData(scanner);
            System.out.println("Cập nhật thành công");
            students[indexExist].displayData();
        }
    }

    public static void deleteStudent(Scanner scanner){
        System.out.print("Nhập vào ID sinh viên muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int indexExist = checkIdExist(id);
        if(indexExist == -1){
            System.out.println("Không tìm thấy ID sinh viên");
        } else {
            for(int i = indexExist; i < currentIndex - 1; i++){
                students[i] = students[i + 1];
            }
            currentIndex--;
            System.out.println("Xóa sinh viên thành công");
        }
    }

    public static void searchStudentByName(Scanner scanner){
        System.out.print("Mời nhập tên xin viên muốn tìm: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentIndex; i++){
            if(students[i].getStudentName().toLowerCase().contains(name.toLowerCase())){
                students[i].displayData();
                found = true;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy sinh viên");
        }
    }
}
