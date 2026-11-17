package ra.tsuptonjv260428_le_gia_khang.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", unique = true, nullable = false, length = 100)
    private String productName;

    @Column(nullable = false)
    private Double price;

    @Column(name = "currency_unit", length = 10, nullable = false)
    private String currencyUnit;

    @Column(name = "import_date", nullable = false)
    private LocalDate importDate;

    @Column(name = "warranty_period", nullable = false)
    private Integer warrantyPeriod;

    @Column(name = "warranty_unit", length = 10)
    private String warrantyUnit;

    @Column(name = "product_image", nullable = false)
    private String productImage;

    private String description;


    private Byte status = 1;

}
