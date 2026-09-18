package bussiness.service;

import bussiness.dao.IMovieDao;
import bussiness.dao.MovieDaoImpl;
import bussiness.model.Movie;
import utils.InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    static IMovieDao iMovieDao = new MovieDaoImpl();
    static List<Movie> movieList = iMovieDao.getAllMovie();

    private static int findMovieById(int id){
        boolean found = false;
        for(Movie movie : movieList){
            if(movie.getId() == id){
                found = true;
                break;
            }
        }
        if(found){
            return id;
        }
        return -1;
    }
    public static void displayAllMovie(){
        for(Movie movie : movieList){
            System.out.println(movie);
        }
    }

    public static void addMovie(Scanner scanner){
        String title = InputData.getString(scanner, "Mời nhập tựa đề phim: ");
        String director = InputData.getString(scanner, "Mời nhập tên đạo diễn: ");
        int year = InputData.getInt(scanner, "Mời nhập năm sản xuất: ");

        iMovieDao.addMovie(title, director, year);
        movieList = iMovieDao.getAllMovie();
        System.out.println("Thêm phim mới thành công!");
    }

    public static void updateMovie(Scanner scanner){
        displayAllMovie();
        int value = InputData.getInt(scanner, "Nhập ID phim cần chỉnh sửa: ");
        int foundId = findMovieById(value);
        if(foundId == -1){
            System.out.println("Không tìm thấy ID phim!");
        } else {
            String title = InputData.getString(scanner, "Mời nhập tựa đề phim: ");
            String director = InputData.getString(scanner, "Mời nhập tên đạo diễn: ");
            int year = InputData.getInt(scanner, "Mời nhập năm sản xuất: ");
            iMovieDao.updateMovie(foundId, title, director, year);
            movieList = iMovieDao.getAllMovie();
            System.out.println("Cập nhật phim thành công!");
        }
    }

    public static void deleteMovie(Scanner scanner){
        displayAllMovie();
        int value = InputData.getInt(scanner, "Nhập ID phim cần xóa: ");
        int foundId = findMovieById(value);
        if(foundId == -1){
            System.out.println("Không tìm thấy ID phim!");
        } else {
            iMovieDao.deleteMovie(foundId);
            movieList = iMovieDao.getAllMovie();
            System.out.println("Xóa phim thành công!");
        }
    }

}
