package ra.tsuptonjv260428_le_gia_khang.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.tsuptonjv260428_le_gia_khang.model.dto.response.ApiResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateResourceException.class)
    public ApiResponse<?> handleDuplicateResourceException(DuplicateResourceException ex){
        return ApiResponse.builder()
                .status(400)
                .message("Dữ liệu đã tồn tại!")
                .data(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<?> handleResourceNotFoundException(ResourceNotFoundException ex){
        return ApiResponse.builder()
                .status(400)
                .message("Không tìm thấy dữ liệu!")
                .data(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<?> handleRuntimeException(RuntimeException ex){
        return ApiResponse.builder()
                .status(400)
                .message("Đã có lỗi xảy ra!")
                .data(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
