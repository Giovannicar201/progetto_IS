package it.unisa.IS_Project.Exception.Sessione;

public class MissingSessionEmailException extends SessionException {
    public MissingSessionEmailException(String message) {
        super(message);
    }
}
