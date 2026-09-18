package bussiness.dao;

import bussiness.model.Movie;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements IMovieDao{


    @Override
    public List<Movie> getAllMovie() {
        List<Movie> movies = new ArrayList<>();
        Connection conn = ConnectionDB.openConnection();
        try {


            CallableStatement call = conn.prepareCall("{CALL list_movies()}");

            ResultSet rs = call.executeQuery();

            while (rs.next()){
                Movie movie = new Movie(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("director"),
                rs.getInt("year"));

                movies.add(movie);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return movies;
    }

    @Override
    public void addMovie(String title, String director, int year) {
        Connection conn = ConnectionDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{CALL add_movie(?,?,?)}");

            call.setString(1,title);
            call.setString(2,director);
            call.setInt(3,year);
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void updateMovie(int id, String title, String director, int year) {
        Connection conn = ConnectionDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{CALL update_movie(?,?,?,?)}");

            call.setInt(1,id);
            call.setString(2,title);
            call.setString(3,director);
            call.setInt(4,year);

            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteMovie(int id) {
        Connection conn = ConnectionDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{CALL delete_movie(?)}");

            call.setInt(1,id);
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
