package bussiness;

import model.Cat;
import model.Dog;
import model.Pet;

import java.util.Scanner;

public class PetService {
    public static Pet[] pets = new Pet[100];
    public static int currentSize = 0;

    public static int IsIdExist(String id){
        for (int i = 0; i < currentSize; i++) {
            if(pets[i].getPetID().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public static void displayPetList(){
        if(currentSize == 0){
            System.out.println("Danh sách hiện tại đang trống");
            return;
        } else {
            for (int i = 0; i < currentSize; i++) {
                pets[i].displayData();
            }
        }
    }

    public static void addPet(Scanner scanner){
        System.out.print("Xin mời nhập ID thú cưng: ");
        String id = scanner.nextLine();
        System.out.print("Xin mời nhập tên thú cưng: ");
        String name = scanner.nextLine();
        System.out.print("Xin mời nhập tuổi thú cưng: ");
        int age = Integer.parseInt(scanner.nextLine());

        if (!id.matches("^[CD]\\d{3}$")) {
            System.out.println("ID không hợp lệ");
            return;
        }

        if(IsIdExist(id) != -1){
            System.out.println("ID đã tồn tại");
            return;
        }

        if(id.charAt(0) == 'D'){
            Pet dog = new Dog(id,name,age);
            pets[currentSize]= dog;
            currentSize++;
            System.out.println("Thêm thú cưng thành công");
        } else {
            Pet cat = new Cat(id,name,age);
            pets[currentSize]= cat;
            currentSize++;
            System.out.println("Thêm thú cưng thành công");
        }
    }



    public static void callSpeak(Scanner scanner){
        displayPetList();
        System.out.print("Chọn ID thú cưng để gọi tiếng kêu: ");
        String id = scanner.nextLine();
        int index = IsIdExist(id);
        if(index == -1){
            System.out.println("Không tìm thấy ID thú cưng");
        } else {
            pets[index].speak();
        }
    }

    public static void deletePet(Scanner scanner){
        displayPetList();
        System.out.print("Chọn ID thú cưng để gọi tiếng kêu: ");
        String id = scanner.nextLine();
        int index = IsIdExist(id);
        if(index == -1){
            System.out.println("Không tìm thấy ID thú cưng");
        } else {
            for (int i = 0; i < currentSize - 1; i++) {
                pets[index] = pets[index + 1];
            }
            currentSize--;
            System.out.println("Xóa thú cưng thành công");
        }
    }

    public static void findPetByName(Scanner scanner){
        boolean flag = false;
        System.out.print("Nhập tên thú cưng cần tìm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < currentSize; i++) {
            if(pets[i].getPetName().contains(name)){
                pets[i].displayData();
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Không tìm thấy tên thú cưng");
        }
    }
}
