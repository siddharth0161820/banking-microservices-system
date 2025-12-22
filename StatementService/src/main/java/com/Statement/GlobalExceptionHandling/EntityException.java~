package com.User.GlobalExceptionHandling;


import org.springframework.http.HttpStatus;

public class EntityException {
    //1>Fields
    private final String message;
    private final HttpStatus httpStatus;
    //2>Constructor

    public EntityException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    //3>Getter

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    //4>toString()

    @Override
    public String toString() {
        return "EntityException{" +
                "message='" + message + '\'' +
                ", httpStatus=" + httpStatus +
                '}';
    }
}
