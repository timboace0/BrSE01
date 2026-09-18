package bussiness.dao;

import bussiness.model.Movie;

import java.util.List;

public interface IMovieDao {
    List<Movie> getAllMovie();
    void addMovie(String title, String director, int year);
    void updateMovie(int id, String title, String director, int year);
    void deleteMovie(int id);
}
