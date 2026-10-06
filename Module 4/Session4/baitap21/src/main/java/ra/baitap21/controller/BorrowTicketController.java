package ra.baitap21.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.baitap21.dto.BorrowResponse;
import ra.baitap21.model.BorrowTicket;
import ra.baitap21.service.BorrowTicketService;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowTicketController {
    private final BorrowTicketService borrowTicketService;

    @PostMapping("/{bookId}")
    public ResponseEntity<?> borrowBook(
            @PathVariable int bookId,
            @RequestParam String studentName
    ) {

        try {

            BorrowTicket ticket =
                    borrowTicketService.borrowBook(bookId, studentName);

            BorrowResponse response =
                    new BorrowResponse(
                            ticket.getStudentName(),
                            ticket.getBook().getTitle(),
                            ticket.getBook().getAuthor().getName(),
                            ticket.getBorrowDate()
                    );

            return ResponseEntity.status(201).body(response);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
