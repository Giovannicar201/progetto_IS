package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Exception.GAC.Login.LoginPasswordsMismatchException;
import it.unisa.IS_Project.Model.Exception.GAC.Login.UserNotFoundException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidEmailException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidNameException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidPasswordException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.SignupPasswordsMismatchException;
import org.json.simple.parser.ParseException;

import java.security.NoSuchAlgorithmException;

public interface UtenteService {
    void signup(String email, String nome, String password, String passwordRipetuta) throws NoSuchAlgorithmException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SignupPasswordsMismatchException;

    void login(String email, String password) throws NoSuchAlgorithmException, UserNotFoundException, LoginPasswordsMismatchException, ParseException;

    UtenteEntity get(String email);
}
