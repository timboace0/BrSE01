package model;

import java.util.Scanner;

public class Student implements IInterface {
    private static int currentID = 1;
    private int id;
    private String studentName;
    private int age;
    private String major;

    public Student() {
        this.id = currentID++;
    }

    public Student(String studentName, int age, String major) {
        this.id = currentID++;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập vào tên sinh viên: ");
        this.studentName = scanner.nextLine();
        System.out.print("Nhập vào tuổi sinh viên: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chuyên ngành: ");
        this.major = scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("| ID: %-3d | Full Name: %-20s | Age: %-3d | Major: %-20s | \n ", this.id, this.studentName, this.age, this.major);
    }
}
