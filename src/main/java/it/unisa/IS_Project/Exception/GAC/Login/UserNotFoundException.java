package it.unisa.IS_Project.Exception.GAC.Login;

public class UserNotFoundException extends LoginException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
