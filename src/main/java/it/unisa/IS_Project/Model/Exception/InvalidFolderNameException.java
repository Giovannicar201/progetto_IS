package it.unisa.IS_Project.Model.Exception;

public class InvalidFolderNameException extends RuntimeException{
    public InvalidFolderNameException(String message) {
        super(message);
    }
}
