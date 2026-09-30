package ra.baitap21.repository;

import ra.baitap21.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    static List<Author> authors = new ArrayList<>(
            List.of(
                    new Author(1,"Nguyen Van A","nguyenvana@gmail.com"),
                    new Author(2,"Nguyen Thi B","bnguyen@gmail.com"),
                    new Author(3,"Le Van C","levanc@gmail.com")
            )
    );

    public List<Author> findAll(){
        return authors;
    }

    public void save(Author author){
        authors.add(author);
    }

    public Author findById(int id){
        return authors.stream()
                .filter(author -> id == author.getId())
                .findFirst().orElse(null);
    }

    public void delete(int id){
        authors.removeIf(author -> author.getId() == id);
    }
}
