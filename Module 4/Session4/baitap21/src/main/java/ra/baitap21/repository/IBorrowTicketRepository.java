package ra.baitap21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ra.baitap21.model.BorrowTicket;

public interface IBorrowTicketRepository extends JpaRepository<BorrowTicket, Long> {

    boolean existsByBookIdAndStatus(Long bookId, String status);
}
