package ra.baitap81.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadService {
    private static final String UPLOAD_DIR = "C:\\Users\\legia\\OneDrive\\Máy tính\\brSE01\\Module 4\\Session8\\baitap81\\uploads";

    public String uploadFileToServer(
            MultipartFile file
    ) {
        try {
            String originalName = file.getOriginalFilename();
            if(originalName == null || !(originalName.toLowerCase().endsWith(".png") || originalName.toLowerCase().endsWith(".jpg"))) {
                throw new IllegalArgumentException(
                        "Chỉ nhận file PNG hoặc JPG!"
                );
            }

            String uuidFileName = UUID.randomUUID().toString() + "_" + originalName;

            Path path = Paths.get(UPLOAD_DIR, uuidFileName);

            Files.createDirectories(path.getParent());
            file.transferTo(path.toFile());

            return UPLOAD_DIR + File.separator + file.getOriginalFilename();
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    };

    public String uploadCvToServer(MultipartFile file){
        try{
            String originalName = file.getOriginalFilename();
            if(originalName == null || !(originalName.toLowerCase().endsWith(".pdf"))) {
                throw new IllegalArgumentException(
                        "Chỉ nhận file PDF"
                );
            }

            String fileName = UUID.randomUUID().toString() + "_" + originalName;
            Path path = Paths.get(UPLOAD_DIR, fileName);

            Files.createDirectories(path.getParent());
            file.transferTo(path.toFile());
            return UPLOAD_DIR + fileName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
