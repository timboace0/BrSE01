package ra.baitap21.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.baitap21.dto.BookRequest;
import ra.baitap21.model.Book;
import ra.baitap21.repository.IBookRepository;
import ra.baitap21.service.BookService;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final IBookRepository bookRepository;

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookRequest request){
        try {
            Book book = bookService.addBook(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){

        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                        );

    }

    @GetMapping("/searchByTitle")
    public ResponseEntity<?> searchByTitle(
            @RequestParam String keyword
    ) {
        return ResponseEntity.ok(
                bookRepository.findByTitleContaining(keyword)
        );
    }

    @GetMapping("/getBookHighPrice")
    public ResponseEntity<?> getBookHighPrice(){
        return ResponseEntity.ok(bookRepository.findBookHighPrice());
    }

    @GetMapping("/statisticsByAuthor")
    public ResponseEntity<?> statisticsByAuthor() {
        return ResponseEntity.ok(
                bookRepository.statisticsByAuthor()
        );
    }

}
