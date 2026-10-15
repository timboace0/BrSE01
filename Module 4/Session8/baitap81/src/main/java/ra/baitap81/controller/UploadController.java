package ra.baitap81.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ra.baitap81.service.UploadService;

@RestController
@RequestMapping("/api/files")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/uploads")
    public ResponseEntity<String> uploadFile(
            @RequestParam("image") MultipartFile file
            ) {
        uploadService.uploadFileToServer(file);
        return new ResponseEntity<>("Upload thành công!", HttpStatus.OK);
    }

}
