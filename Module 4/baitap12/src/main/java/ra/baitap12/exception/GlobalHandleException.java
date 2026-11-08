package ra.baitap12.exception;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.baitap12.model.dto.response.ApiResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(NoSuchElementException.class)
    public ApiResponse<?> handleNoSuchElementException(
            NoSuchElementException ex) {

        return new ApiResponse<>(
                404,
                ex.getMessage(),
                null
        );
    }

}
