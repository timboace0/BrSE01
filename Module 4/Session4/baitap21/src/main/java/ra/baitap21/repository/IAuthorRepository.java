package ra.baitap21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap21.model.Author;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
}

