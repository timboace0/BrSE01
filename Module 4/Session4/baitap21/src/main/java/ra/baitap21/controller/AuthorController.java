package ra.baitap21.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.baitap21.service.AuthorService;
import ra.baitap21.model.Author;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> addNewAuthors(@RequestBody Author newAuthor){
        authorService.addAuthor(newAuthor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAuthor);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable int id){
        Author author = authorService.findbyId(id);

        if(author == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(author);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") int id, @RequestBody Author request){
        Author author = authorService.updateAuthor(id, request);
        if(author == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(author);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") int id){
        Author author = authorService.findbyId(id);

        if(author == null){
            return ResponseEntity.notFound().build();
        }
        if(author.getName().equalsIgnoreCase("admin")) {
            return ResponseEntity.badRequest().body("Không được phép xóa tài khoản quản trị (Admin)");
        }
            boolean del = authorService.deleteAuthor(id);
            if(del){
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        }

    @GetMapping("/authors/search")
    public ResponseEntity<?> findAuthorByName(@RequestParam("name") String keyword){
        if(authorService.searchAuthors(keyword).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authorService.searchAuthors(keyword));
    }

}





