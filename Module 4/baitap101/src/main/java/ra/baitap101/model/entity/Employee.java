package ra.baitap101.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
public class Employee {
    private Integer id;
    private String fullName;
    private Double salary;
}
