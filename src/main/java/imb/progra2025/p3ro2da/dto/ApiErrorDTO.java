package imb.progra2025.p3ro2da.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ApiErrorDTO {
    private boolean success;
    private String error;
    private List<String> details;
    private LocalDateTime timestamp;

    public ApiErrorDTO() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrorDTO(String error, List<String> details) {
        this();
        this.success = false;
        this.error = error;
        this.details = details;
    }

    // Getters y setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
