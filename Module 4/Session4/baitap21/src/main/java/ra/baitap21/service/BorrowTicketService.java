package ra.baitap21.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.baitap21.model.Book;
import ra.baitap21.model.BorrowTicket;
import ra.baitap21.repository.IBookRepository;
import ra.baitap21.repository.IBorrowTicketRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BorrowTicketService {
    private IBorrowTicketRepository borrowTicketRepository;
    private IBookRepository bookRepository;

    @Transactional
    public BorrowTicket borrowBook(int bookId, String studentName){

    Book book = bookRepository.findById((long)bookId).orElseThrow(
                () -> new RuntimeException("Sách không tồn tại!")
        );

    boolean borrowed = borrowTicketRepository.existsByBookIdAndStatus((long) bookId, "BORROWED");

    if (borrowed){
        throw new RuntimeException("Sách đang được mượn!");
    }

    BorrowTicket borrowTicket = new BorrowTicket();
    borrowTicket.setStudentName(studentName);
    borrowTicket.setBorrowDate(LocalDate.now());
    borrowTicket.setBook(book);
    borrowTicket.setStatus("BORROWED");

    return borrowTicketRepository.save(borrowTicket);
    }
}
