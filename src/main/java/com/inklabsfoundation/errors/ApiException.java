package com.inklabsfoundation.errors;

public class ApiException extends RuntimeException {
    public final String error;
    public final String data;


    public ApiException(String error, String data, String message) {
        super(message);
        this.error = error;
        this.data = data;
    }

    public static class ApiErrorResponse {
        public String error;
        public String data;
        public String message;

        public ApiErrorResponse() {
        }
    }
}