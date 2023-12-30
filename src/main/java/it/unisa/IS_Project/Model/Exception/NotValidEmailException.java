package it.unisa.IS_Project.Model.Exception;

public class NotValidEmailException extends RuntimeException{
    public NotValidEmailException(String message) {
        super(message);
    }
}
