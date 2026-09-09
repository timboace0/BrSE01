package model;

import java.util.Scanner;

public abstract class Pet implements IPet {
    private String petID;
    private String petName;
    private int age;

    public Pet() {
    }

    public Pet(String petID, String petName, int age) {
        this.petID = petID;
        this.petName = petName;
        this.age = age;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        if(petID.matches("^[CD]\\d{3}$")){
            char d1 = petID.charAt(1);
            char d2 = petID.charAt(3);
            char d3 = petID.charAt(4);
            if(d1 != d2 && d2 != d3 && d1 != d3){
                this.petID = petID;
            }
        } else {
            System.out.println("ID không hợp lệ");
        }
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        if(petName.matches("^.{20,50}$")){
            this.petName = petName;
        } else {
            System.out.println("Tên thú cưng không hợp lệ");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0){
            this.age = age;
        } else {
            System.out.println("Tuổi không hợp lệ");
        }
    }

    @Override
    public void inputData(Scanner scanner){
        System.out.print("Nhập mã thú cưng: ");
        petID = scanner.nextLine();
        System.out.print("Nhập tên thú cưng: ");
        petName = scanner.nextLine();
        System.out.print("Nhập tuổi thú cưng: ");
        age = Integer.parseInt(scanner.nextLine());

    }

    @Override
    public void displayData() {
        System.out.printf("ID: %-5s | Name: %-35s | Age: %-5d \n", petID, petName, age);
    }

    public abstract void speak();
}
