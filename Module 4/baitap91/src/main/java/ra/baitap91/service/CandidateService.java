
package ra.baitap91.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ra.baitap91.model.dto.request.CandidateApplyDTO;
import ra.baitap91.model.entity.Candidate;
import ra.baitap91.repository.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UploadService uploadService;

    @Transactional
    public Candidate apply(CandidateApplyDTO dto) {

        MultipartFile cvFile = dto.getCvFile();

        if (cvFile == null || cvFile.isEmpty()) {
            throw new IllegalArgumentException("Vui lòng chọn file CV!");
        }

        String fileName = cvFile.getOriginalFilename();

        if (fileName == null
                || !fileName.toLowerCase().endsWith(".pdf")) {
            throw new IllegalArgumentException("CV chỉ được phép là file PDF!");
        }

        String cvUrl = uploadService.uploadCloudinary(cvFile);

        Candidate candidate = Candidate.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .cvUrl(cvUrl)
                .build();

        Candidate savedCandidate = candidateRepository.save(candidate);
        return savedCandidate;
    }
}
