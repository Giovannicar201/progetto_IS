package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GAC.Login.LoginException;
import it.unisa.IS_Project.Model.Exception.GAC.Login.LoginPasswordsMismatchException;
import it.unisa.IS_Project.Model.Exception.GAC.Login.UserNotFoundException;
import it.unisa.IS_Project.Model.Exception.GAC.Logout.LogoutException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.*;
import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Service.UtenteService;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
public class UtenteControl {

    @Autowired
    public UtenteService utenteService;

    @RequestMapping(value = "/auth/signup", method = RequestMethod.POST)

    public void signup(@RequestBody String signup, HttpServletRequest request, HttpServletResponse response) throws SignupException {

        JSONParser parser = new JSONParser();
        String email = null, nome, password, passwordRipetuta;

        try {

            JSONObject signupJSON = (JSONObject) parser.parse(signup);

            email = (String) signupJSON.get("email");
            nome = (String) signupJSON.get("nome");
            password = (String) signupJSON.get("password");
            passwordRipetuta = (String) signupJSON.get("passwordRipetuta");

            utenteService.signup(email,nome,password,passwordRipetuta);

        } catch (NoSuchAlgorithmException | ParseException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new SignupException("ERRORE - NOSUCHALGORITHEXCEPTION || PARSEEXCEPTION.");
            }

        } catch (SignupPasswordsMismatchException e) {

            try {
                response.sendError(500, "SPME");
            } catch (IOException ex) {
                throw new SignupException("ERRORE - SIGNUP IOEXCEPTION.");
            }

        } catch (InvalidNameException e) {

            try {
                response.sendError(500, "INE");
            } catch (IOException ex) {
                throw new SignupException("ERRORE - SIGNUP IOEXCEPTION.");
            }

        } catch (InvalidPasswordException e) {

            try {
                response.sendError(500, "IPE");
            } catch (IOException ex) {
                throw new SignupException("ERRORE - SIGNUP IOEXCEPTION.");
            }

        } catch (InvalidEmailException e) {

            try {
                response.sendError(500, "IEE");
            } catch (IOException ex) {
                throw new SignupException("ERRORE - SIGNUP IOEXCEPTION.");
            }

        } catch (NotUniqueUserException e) {

            try {
                response.sendError(500, "NUUE");
            } catch (IOException ex) {
                throw new SignupException("ERRORE - SIGNUP IOEXCEPTION.");
            }

        }

        SessionManager.setEmail(request,email);
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)

    public void login(@RequestBody String login, HttpServletRequest request, HttpServletResponse response) throws LoginException {

        JSONParser parser = new JSONParser();
        String email, password;

        try {

            JSONObject loginJSON = (JSONObject) parser.parse(login);

            email = (String) loginJSON.get("email");
            password = (String) loginJSON.get("password");

            utenteService.login(email,password);

            SessionManager.setEmail(request,email);

        } catch (NoSuchAlgorithmException | ParseException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new LoginException("ERRORE - NOSUCHALGORITHEXCEPTION || PARSEEXCEPTION.");
            }

        } catch (UserNotFoundException e) {

            try {
                response.sendError(500, "UNFE");
            } catch (IOException ex) {
                throw new LoginException("ERRORE - LOGIN IOEXCEPTION.");
            }

        } catch (LoginPasswordsMismatchException e) {

            try {
                response.sendError(500, "LPME");
            } catch (IOException ex) {
                throw new LoginException("ERRORE - LOGIN IOEXCEPTION.");
            }

        }
    }

    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST)

    public void logout(HttpServletRequest request, HttpServletResponse response) throws LogoutException {

        try {

            SessionManager.getEmail(request);

            request.getSession().invalidate();

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new LogoutException("ERRORE - CARICA IMMAGINE IOEXCEPTION.");
            }

        }
    }

}
