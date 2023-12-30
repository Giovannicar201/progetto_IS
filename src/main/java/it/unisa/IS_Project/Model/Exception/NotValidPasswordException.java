package it.unisa.IS_Project.Model.Exception;

public class NotValidPasswordException extends RuntimeException{
    public NotValidPasswordException(String message) {
        super(message);
    }
}
