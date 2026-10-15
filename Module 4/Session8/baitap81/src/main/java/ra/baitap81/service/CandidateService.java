package ra.baitap81.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap81.model.dto.request.CandidateDTO;
import ra.baitap81.model.entity.Candidate;
import ra.baitap81.repository.CandidateRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public void applyCv(CandidateDTO candidateDTO, String CvUrl){
        Candidate candidate = new Candidate();
        candidate.setFullName(candidateDTO.getFullName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setSkills(candidateDTO.getSkills());
        candidate.setCvUrl(CvUrl);

        candidateRepository.applyCv(candidate);
    }

    }
