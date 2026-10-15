package ra.baitap81.repository;

import org.springframework.stereotype.Repository;
import ra.baitap81.model.dto.request.CandidateDTO;
import ra.baitap81.model.entity.Candidate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CandidateRepository {
    List<Candidate> candidates = new ArrayList<>();

    public void applyCv(Candidate candidate){
        candidates.add(candidate);
    }
}
