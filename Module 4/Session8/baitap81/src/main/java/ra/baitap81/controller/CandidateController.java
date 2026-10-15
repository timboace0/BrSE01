package ra.baitap81.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ra.baitap81.model.dto.request.CandidateDTO;
import ra.baitap81.service.CandidateService;
import ra.baitap81.service.UploadService;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private UploadService uploadService;

    @PostMapping("apply")
    public ResponseEntity<?> applyJob(
            @RequestPart("candidate") CandidateDTO candidateDTO,
            @RequestPart("cv") MultipartFile file
            ) {

        String fileName = uploadService.uploadCvToServer(file);
        candidateService.applyCv(candidateDTO,fileName);
        return new ResponseEntity<>("Đăng ký thành công", HttpStatus.CREATED);
    }
}
