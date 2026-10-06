package ra.baitap21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ra.baitap21.model.Book;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitleContaining(String keyword);

    @Query("SELECT b FROM Book b WHERE b.price > (SELECT AVG(b2.price) FROM Book b2)")
    List<Book> findBookHighPrice();

    @Query(value = """
        SELECT author_id, COUNT(*) AS book_count
        FROM book
        GROUP BY author_id
        """, nativeQuery = true)
    List<Object[]> statisticsByAuthor();
}
