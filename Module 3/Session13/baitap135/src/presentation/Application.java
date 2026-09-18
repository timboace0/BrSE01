package presentation;

import bussiness.service.MovieService;
import utils.InputData;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {
//        Connection conn = ConnectionDB.openConnection();
//        if(conn != null){
//            System.out.println("Thành công");
//        } else {
//            System.out.println("Thất bại");
//        }
//        ConnectionDB.closeConnection(conn);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    ================ QUẢN LÝ PHIM ===============
                    1. Thêm Phim
                    2. Liệt Kê Phim
                    3. Sửa Phim 
                    4. Xóa Phim
                    5. Thoát chương trình
                    """);
            choice = InputData.getInt(scanner, "Lựa chọn của bạn: ");
            switch (choice){
                case 1:{
                    MovieService.addMovie(scanner);
                    break;
                }
                case 2:{
                    MovieService.displayAllMovie();
                    break;
                }
                case 3:{
                    MovieService.updateMovie(scanner);
                    break;
                }
                case 4:{
                    MovieService.deleteMovie(scanner);
                    break;
                }
                case 5:{
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
            }
        } while (true);
    }
}