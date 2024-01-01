package it.unisa.IS_Project.Model.Exception.GAC.Logout;

public class EmptySessionException extends LogoutException{
    public EmptySessionException(String message) {
        super(message);
    }
}
