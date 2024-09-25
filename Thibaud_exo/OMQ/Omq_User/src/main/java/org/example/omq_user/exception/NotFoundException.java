package org.example.omq_user.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("User Not Found");
    }
}
