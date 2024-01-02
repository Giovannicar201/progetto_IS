package it.unisa.IS_Project.Model.Exception.Session;

public class MissingSessionEmailException extends SessionException {
    public MissingSessionEmailException(String message) {
        super(message);
    }
}
