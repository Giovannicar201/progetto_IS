package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Exception.NotValidEmailException;
import it.unisa.IS_Project.Model.Exception.NotValidNameException;
import it.unisa.IS_Project.Model.Exception.NotValidPasswordException;
import it.unisa.IS_Project.Model.Service.UtenteService;
import it.unisa.IS_Project.Utility.UtilityClass;
import it.unisa.IS_Project.Utility.ValidatorClass;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
public class UtenteControl {

    @Autowired
    public UtenteService utenteService;

    @RequestMapping(value = "/login/login", method = RequestMethod.POST)

    public String loginUser(@ModelAttribute UtenteEntity infoUtente, HttpServletRequest request){

        String email=request.getParameter("email");
        String password=request.getParameter("password");

        UtilityClass.salvaEmail(request.getSession(), infoUtente.getEmail());

        if(email==infoUtente.getEmail() && password==infoUtente.getPassword()){
            request.getSession().setAttribute("email",email);
        }

        return "redirect:/login";

    }

    @RequestMapping(value = "/login/registrazione", method = RequestMethod.POST)

    public String registUser(@ModelAttribute UtenteEntity infoUtente, HttpServletRequest request){

        if(!ValidatorClass.emailValidator(infoUtente.getEmail())) {
            throw new NotValidEmailException("Email non valida!");
        }

        if(infoUtente.getNome().length()<2 || infoUtente.getNome().length()>32){
            throw new NotValidNameException("Nome troppo piccolo");
        }

        if(!ValidatorClass.passwordValidator(infoUtente.getPassword())){
            throw new NotValidPasswordException("Password non valida!");
        }

        UtenteEntity utente = null;

        try{
             utente = utenteService.add(infoUtente.getEmail(), infoUtente.getPassword(), infoUtente.getNome());
        }catch (NoSuchAlgorithmException e){
            return "redirect:/error";
        }

        UtilityClass.salvaEmail(request.getSession(), infoUtente.getEmail());

        request.getSession().setAttribute("email",utente.getEmail());

        if(request.getSession()!=null && request.getSession().getAttribute("email")!=null){
            System.out.println("Sei in sessione");
        }else {
            System.out.println("Non sei in sessione");
        }

        return "redirect:/login";

    }

}