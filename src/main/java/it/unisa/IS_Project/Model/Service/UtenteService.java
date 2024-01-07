package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Exception.GAC.*;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import org.json.simple.parser.ParseException;
import java.security.NoSuchAlgorithmException;

public interface UtenteService {
    void signup(String email, String nome, String password, String passwordRipetuta) throws NoSuchAlgorithmException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SignupPasswordsMismatchException, NotUniqueUserException;

    void login(String email, String password) throws NoSuchAlgorithmException, UserNotFoundException, LoginPasswordsMismatchException, ParseException;

    UtenteEntity get(String email);
}
