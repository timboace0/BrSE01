package ra.baitap21.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowResponse {
    private String studentName;
    private String bookTitle;
    private String authorName;
    private LocalDate borrowDate;
}
