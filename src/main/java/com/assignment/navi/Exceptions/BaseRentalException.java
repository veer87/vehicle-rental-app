package com.assignment.navi.Exceptions;

public class BaseRentalException extends Exception {
    private String message;

    public BaseRentalException(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
