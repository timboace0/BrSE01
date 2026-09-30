package ra.baitap21.service;

import ra.baitap21.model.Author;
import org.springframework.stereotype.Service;
import ra.baitap21.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    };

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public Author findbyId(int id){
        return authorRepository.findById(id);
    }

    public Author updateAuthor(int id, Author request){
        Author author = authorRepository.findById(id);
        if(author == null){
            System.out.println("Không tìm thấy tác giả!");
            return null;
        } else {
            author.setName(request.getName());
            author.setEmail(request.getEmail());
            return author;
        }
    }

    public Boolean deleteAuthor(int id){
        Author author = authorRepository.findById(id);
        if(author == null){
            return false;
        } else if(author.getName().equalsIgnoreCase("admin")){
            return false;
        }
        authorRepository.delete(id);
        return true;
    }

    public List<Author> searchAuthors(String keyword){
        List<Author> result = new ArrayList<>();
        result = authorRepository.findAll().stream().filter(author -> author.getName().toLowerCase().contains(keyword.toLowerCase())).toList();
        return result;
    }
}
