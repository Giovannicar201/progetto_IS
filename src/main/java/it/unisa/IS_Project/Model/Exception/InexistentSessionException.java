package it.unisa.IS_Project.Model.Exception;

public class InexistentSessionException extends RuntimeException{
    public InexistentSessionException(String message) {
        super(message);
    }
}
