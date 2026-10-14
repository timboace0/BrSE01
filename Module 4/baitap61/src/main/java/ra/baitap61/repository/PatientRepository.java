package ra.baitap61.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap61.model.dto.response.PaginationResponse;
import ra.baitap61.model.entity.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByFullNameContaining(String keyword, Pageable pageable);
}
