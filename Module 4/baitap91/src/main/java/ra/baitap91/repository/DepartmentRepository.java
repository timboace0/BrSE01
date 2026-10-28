package ra.baitap91.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap91.model.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
