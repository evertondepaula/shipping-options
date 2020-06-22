package com.code.challenge.responses;

import org.springframework.http.HttpStatus;

public class DeleteResponse {

    private HttpStatus code;
    private String message;

    public DeleteResponse(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
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
}
