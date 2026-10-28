
package ra.baitap91.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.baitap91.model.dto.request.CandidateApplyDTO;
import ra.baitap91.model.entity.Candidate;
import ra.baitap91.service.CandidateService;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/apply")
    public ResponseEntity<Candidate> apply(
            @Valid @ModelAttribute CandidateApplyDTO dto) {

        Candidate candidate = candidateService.apply(dto);

        return new ResponseEntity<>(candidate, HttpStatus.CREATED);
    }
}
