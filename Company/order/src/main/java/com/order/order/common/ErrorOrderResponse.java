package com.order.order.common;

import lombok.Getter;


public class ErrorOrderResponse implements OrderResponse {
    private final String errorMessage;

    public ErrorOrderResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
