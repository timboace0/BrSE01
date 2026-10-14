package ra.baitap61.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap61.model.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
