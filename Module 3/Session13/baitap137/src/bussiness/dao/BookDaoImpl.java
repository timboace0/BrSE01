package bussiness.dao;

import bussiness.model.Book;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {

    @Override
    public boolean addBook(Book book) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL add_book(?,?,?,?)}");

            call.setString(1, book.getTitle());
            call.setString(2, book.getAuthor());
            call.setInt(3, book.getPublishedYear());
            call.setBigDecimal(4, book.getPrice());

            call.executeUpdate();

            return true;

        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                return false;
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean updateBook(int id, Book book) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL update_book(?,?,?,?,?)}");

            call.setInt(1, id);
            call.setString(2, book.getTitle());
            call.setString(3, book.getAuthor());
            call.setInt(4, book.getPublishedYear());
            call.setBigDecimal(5, book.getPrice());

            call.executeUpdate();

            return true;

        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                return false;
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean deleteBook(int id) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL delete_book(?)}");

            call.setInt(1, id);

            call.executeUpdate();

            return true;

        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                return false;
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        List<Book> books = new ArrayList<>();

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL find_books_by_author(?)}");

            call.setString(1, author);

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("published_year"),
                        rs.getBigDecimal("price")
                );

                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return books;
    }

    @Override
    public List<Book> listAllBooks() {
        List<Book> books = new ArrayList<>();

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL list_all_books()}");

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("published_year"),
                        rs.getBigDecimal("price")
                );

                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return books;
    }
}