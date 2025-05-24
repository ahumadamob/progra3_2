package imb.progra2025.p3ro2da.dto;

import java.time.LocalDateTime;

public class ApiResponseDTO<T> {
    private boolean success;
    private T data;
    private String message;
    private LocalDateTime timestamp;

    public ApiResponseDTO() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponseDTO(T data, String message) {
        this();
        this.success = true;
        this.data = data;
        this.message = message;
    }

    // Getters y setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
