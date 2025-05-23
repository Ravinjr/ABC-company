package com.base.base.dto;

public class OrderEventDTO {
    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderEventDTO() {
    }

    public OrderEventDTO(String message, String status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderEventDTO{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
