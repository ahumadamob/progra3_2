package imb.progra2025.p3ro2da.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import imb.progra2025.p3ro2da.dto.ApiErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiErrorDTO error = new ApiErrorDTO();
        error.setSuccess(false);
        error.setError("Recurso no encontrado");
        error.setDetails(List.of(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleAnyException(Exception ex) {
        ApiErrorDTO error = new ApiErrorDTO();
        error.setSuccess(false);
        error.setError("Error de procesamiento");
        error.setDetails(List.of(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult().getFieldErrors()
            .stream()
            .map(err -> err.getField() + ": " + err.getDefaultMessage())
            .collect(Collectors.toList());

        ApiErrorDTO error = new ApiErrorDTO();
        error.setSuccess(false);
        error.setError("Error de validacion");
        
        error.setDetails(errores);
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error);
    }
}

