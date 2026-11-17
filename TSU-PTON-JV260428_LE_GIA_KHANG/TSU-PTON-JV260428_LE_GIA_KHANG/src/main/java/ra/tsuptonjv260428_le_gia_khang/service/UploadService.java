package ra.tsuptonjv260428_le_gia_khang.service;

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
    private final String UPLOAD_DIR = "uploads";

    public String uploadFileToServer(MultipartFile file){
        try {
            String originalName = file.getOriginalFilename();
            if(originalName == null){
                throw new RuntimeException("tên file rỗng");
            }

            String uuidFileName = UUID.randomUUID().toString() + "_" + originalName;

            Path uploadPath = Paths.get(System.getProperty("user.dir"),UPLOAD_DIR);
            Files.createDirectories(uploadPath);
            Path path = uploadPath.resolve(uuidFileName);
            file.transferTo(path.toFile());

            return UPLOAD_DIR + File.separator + uuidFileName;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
