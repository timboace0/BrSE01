package ra.baitap91.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class HandleFileImageValidation implements ConstraintValidator<CheckFileImage, MultipartFile> {

    @Override
    public boolean isValid(
            MultipartFile file,
            ConstraintValidatorContext context) {

        if (file == null || file.isEmpty()) {
            return false;
        }

        String fileName = file.getOriginalFilename();

        if (fileName == null || !fileName.contains(".")) {
            return false;
        }

        List<String> extensions = Arrays.asList("png", "jpg", "jpeg");

        String extension = fileName
                .substring(fileName.lastIndexOf(".") + 1)
                .toLowerCase();

        if (!extensions.contains(extension)) {
            return false;
        }

        long maxSize = 2 * 1024 * 1024;

        return file.getSize() <= maxSize;
    }
}
