package presentation;

import bussiness.model.Movie;
import bussiness.service.MovieManager;
import utils.InputData;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManager<Movie> movieManager = new MovieManager<>();
        int choice;
        do {
            System.out.println("""
                    Chọn chức năng
                    1. Thêm phim
                    2. Xóa phim
                    3. Sửa phim
                    4. Hiển thị phim
                    5. Tìm kiếm phim theo tên
                    6. Lọc phim theo Rating
                    7. Thoát
                    """);
            choice = InputData.getInt(scanner, "Lựa chọn của bạn: ");
            switch (choice){
                case 1: {
                    movieManager.addMovie(scanner);
                    break;
                }
                case 2: {
                    movieManager.deleteMovie(scanner);
                    break;
                }
                case 3: {
                    movieManager.editMovie(scanner);
                    break;
                }
                case 4: {
                    movieManager.displayAllMovie();
                    break;
                }
                case 5: {
                    movieManager.findMovieByName(scanner);
                    break;
                }
                case 6: {
                    movieManager.filterMovieRating();
                    break;
                }
                case 7: {
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (true);
    }
}