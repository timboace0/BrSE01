package ra.baitap12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap12.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Boolean existsByEmail(String email);
}
