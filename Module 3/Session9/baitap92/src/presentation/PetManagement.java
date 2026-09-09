package presentation;

import bussiness.PetService;

import java.util.Scanner;

public class PetManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    *********************QUẢN LÝ THÚ CƯNG********************
                    
                    1. Hiển thị danh sách thú cưng
                    
                    2. Thêm thú cưng
                    
                    3. Gọi tiếng kêu
                    
                    4. Xóa thú cưng
                    
                    5. Tìm thú cưng theo tên
                    
                    6. Thoát
                    
                    Lựa chọn của bạn: 
                    
                    """);
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:{
                    PetService.displayPetList();
                    break;
                }
                case 2:{
                    PetService.addPet(scanner);
                    break;
                }
                case 3:{
                    PetService.callSpeak(scanner);
                    break;
                }
                case 4:{
                    PetService.deletePet(scanner);
                    break;
                }
                case 5:{
                    PetService.findPetByName(scanner);
                    break;
                }
                case 6:{
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while(true);
    }
}