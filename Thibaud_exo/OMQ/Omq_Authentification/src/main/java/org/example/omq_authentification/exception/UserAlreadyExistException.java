package org.example.omq_authentification.exception;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException() {
        super("User Already Exist");
    }
}
