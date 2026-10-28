package ra.baitap91.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap91.model.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
