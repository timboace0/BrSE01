package ra.baitap91.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadService {
    @Autowired
    private Cloudinary cloudinary;

    public String uploadCloudinary(MultipartFile file){
        try {
            Map<String,Object> upload =  cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return upload.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
