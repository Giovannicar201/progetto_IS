package it.unisa.IS_Project.Model.Exception.Sessione;

public class MissingSessionEmailException extends SessionException {
    public MissingSessionEmailException(String message) {
        super(message);
    }
}
