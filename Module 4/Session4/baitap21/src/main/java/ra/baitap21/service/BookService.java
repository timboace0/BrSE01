package ra.baitap21.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.baitap21.dto.BookRequest;
import ra.baitap21.model.Author;
import ra.baitap21.model.Book;
import ra.baitap21.repository.IAuthorRepository;
import ra.baitap21.repository.IBookRepository;

@Service
@RequiredArgsConstructor
public class BookService {

    private final IBookRepository bookRepository;
    private final IAuthorRepository authorRepository;

    public Book addBook(BookRequest request){

        Author author = authorRepository
                .findById((long) request.getAuthorId())
                .orElse(null);

        if(author == null){
            throw new RuntimeException("Tác giả không tồn tại!");
        }

        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setPrice(request.getPrice());
        book.setAuthor(author);

        return bookRepository.save(book);
    }

}
