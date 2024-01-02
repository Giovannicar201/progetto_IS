package it.unisa.IS_Project.Model.Exception.GAC.Logout;

public class EmailNotInSessionException extends LogoutException{
    public EmailNotInSessionException(String message) {
        super(message);
    }
}
