package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GAC.Login.LoginPasswordsMismatchException;
import it.unisa.IS_Project.Model.Exception.GAC.Login.UserNotFound;
import it.unisa.IS_Project.Model.Exception.GAC.Logout.EmptySessionException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidEmailException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidNameException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidPasswordException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.SignupPasswordsMismatchException;
import it.unisa.IS_Project.Model.Service.UtenteService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
public class UtenteControl {

    @Autowired
    public UtenteService utenteService;

    @RequestMapping(value = "/auth/signup", method = RequestMethod.POST)

    public String signup(@RequestParam String email,
                             @RequestParam String nome,
                             @RequestParam String password,
                             @RequestParam String passwordRipetuta, HttpServletRequest request){

        try {
            utenteService.signup(email,nome,password,passwordRipetuta);
        } catch (NoSuchAlgorithmException e) {
            // TO DO
        } catch (SignupPasswordsMismatchException e) {
            // TO DO
        } catch (InvalidNameException e) {
            // TO DO
        } catch (InvalidPasswordException e) {
            // TO DO
        } catch (InvalidEmailException e) {
            // TO DO
        }

        UtilityClass.salvaEmail(request,email);

        return "redirect:/auth";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)

    public String login(@RequestBody String string, HttpServletRequest request, Model model){
        /*


        ANGELO E GIOVANNI SE LEGGETE QUESTO COMMENTO ORA IO VI PASSO UN JSON TRAMITE ASYNC
        GESTITEVELO VOI
        BACIONI



        try {

            utenteService.login(email,password);

        } catch (NoSuchAlgorithmException e) {

            // TO DO

        } catch (UserNotFound e) {

            model.addAttribute("errore", "utente non trovato!");

            return "LogInRegistrazione";

        } catch (LoginPasswordsMismatchException e) {

            model.addAttribute("errore", "password errata!");

            return "LogInRegistrazione";

        }

        UtilityClass.salvaEmail(request,email);

        return "redirect:/auth";*/

        System.out.println(string);

        return "redirect:/auth";

    }

    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST)

    public String logout(HttpServletRequest request){

        try {
            UtilityClass.emailSessione(request);
        } catch (EmptySessionException e) {
            return "redirect:/error";
        }

        if (request.getSession() != null)
            request.getSession().setMaxInactiveInterval(1);

        return "redirect:/auth";
    }

}
