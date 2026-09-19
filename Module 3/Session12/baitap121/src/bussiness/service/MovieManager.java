package bussiness.service;

import bussiness.model.Movie;
import utils.InputData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieManager<T extends Movie> {
    List<T> movies = new ArrayList<>();

    public void displayAllMovie(){
        if(movies.isEmpty()){
            System.out.println("Danh sách phim đang trống!");
        }
        for (T movie : movies){
            System.out.println(movie);
        }
    }

    public void addMovie(Scanner scanner){
        int id = InputData.getInt(scanner, "Mời nhập ID phim: ");
        int index = isIdExist(id);
        if(index != -1){
            System.out.println("ID phim đã tồn tại");
            return;
        }
        String title = InputData.getString(scanner,"Mời nhập tựa đề phim: ");
        String director = InputData.getString(scanner,"Mời nhập tên tác giả: ");
        LocalDate date = InputData.getDate(scanner,"Mời nhập ngày phát hành (dd-MM-yyyy): ");
        Float rating = InputData.getFloat(scanner, "Mời nhập rating: ");

        Movie movie = new Movie(id,title,director,date,rating);
        movies.add((T) movie);
        System.out.println("Thêm phim mới thành công");
    }

    public int isIdExist(int id) {
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public void editMovie(Scanner scanner){
        displayAllMovie();
        int id = InputData.getInt(scanner, "Mời nhập ID phim cần sửa: ");
        int index = isIdExist(id);
        if(index == -1){
            System.out.println("Không tìm thấy ID phim!");
        } else {
            String title = InputData.getString(scanner,"Mời nhập tựa đề phim: ");
            String director = InputData.getString(scanner,"Mời nhập tên tác giả: ");
            LocalDate date = InputData.getDate(scanner,"Mời nhập ngày phát hành (dd-MM-yyyy): ");
            Float rating = InputData.getFloat(scanner, "Mời nhập rating: ");

            Movie newMovie = new Movie(id,title,director,date,rating);
            movies.set(index, (T) newMovie);
            System.out.println("Cập nhật phim thành công!");
        }
    }

    public void deleteMovie(Scanner scanner){
        displayAllMovie();
        int id = InputData.getInt(scanner, "Mời nhập ID phim cần xóa: ");
        int index = isIdExist(id);
        if(index == -1){
            System.out.println("Không tìm thấy ID phim!");
        } else {
            movies.remove(index);
            System.out.println("Xóa phim thành công!");
        }
    }

    public void findMovieByName(Scanner scanner){
        String input = InputData.getString(scanner, "Mời nhập tên phim cần tìm kiếm: ");
        boolean found = false;
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getTitle().contains(input)){
                System.out.println(movies.get(i));
                found = true;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy tên phim");
        }
    }

    public void filterMovieRating(){
        boolean found = false;
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getRating() > 8.0){
                System.out.println(movies.get(i));
                found = true;
            }
        }
        if(!found){
            System.out.println("Không có phim rating > 8.0");
        }
    }
}
