package com.code.challenge.responses;

import java.util.Map;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus code;
    private String message;
    private Map<String, String> errors;

    public ErrorResponse(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
    }

    public ErrorResponse(String message, HttpStatus code, Map<String, String> errors) {
        this.message = message;
        this.code = code;
        this.errors = errors;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
