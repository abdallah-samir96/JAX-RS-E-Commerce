package iti.dtos;

public class ResponseDTO {
    private String message;

    public ResponseDTO() {

    }

    public ResponseDTO(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
