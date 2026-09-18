package bussiness.dao;

import bussiness.model.Book;

import java.util.List;

public interface IBookDao {

    boolean addBook(Book book);

    boolean updateBook(int id, Book book);

    boolean deleteBook(int id);

    List<Book> findBooksByAuthor(String author);

    List<Book> listAllBooks();
}