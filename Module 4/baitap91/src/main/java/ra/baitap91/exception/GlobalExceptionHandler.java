package ra.baitap91.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.baitap91.model.dto.response.ApiResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ApiResponse.<Map<String,String>>builder()
                .status("FAIL")
                .message("Dữ liệu không hợp lệ!")
                .data(errors)
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Map<String,String>> handleResourceNotFoundException(ResourceNotFoundException ex){
        Map<String,String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());

        return ApiResponse.<Map<String,String>>builder()
                .status("FAIL")
                .message("Dữ liệu không hợp lệ!")
                .data(errors)
                .build();
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ApiResponse<Map<String,String>> handleDuplicateResourceException(DuplicateResourceException ex){
        Map<String,String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());

        return ApiResponse.<Map<String,String>>builder()
                .status("FAIL")
                .message("Dữ liệu trùng lặp!")
                .data(errors)
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleConstraintViolationException(
            ConstraintViolationException ex) {

        Map<String, String> errors = new HashMap<>();

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.put(
                    violation.getPropertyPath().toString(),
                    violation.getMessage()
            );
        }

        return ResponseEntity.badRequest().body(
                ApiResponse.<Map<String, String>>builder()
                        .status("FAIL")
                        .message("Dữ liệu không hợp lệ!")
                        .data(errors)
                        .build()
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        return ResponseEntity.badRequest().body(
                ApiResponse.<String>builder()
                        .status("FAIL")
                        .message(ex.getMessage())
                        .build()
        );
    }
}
