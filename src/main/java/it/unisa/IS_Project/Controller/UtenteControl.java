package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Service.UtenteService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtenteControl {

    @Autowired
    public UtenteService utenteService;

    @RequestMapping(value = "/login/login", method = RequestMethod.POST)

    public String loginUser(@ModelAttribute UtenteEntity infoUtente, HttpServletRequest request){

        //[...]

        UtilityClass.salvaEmail(request.getSession(), infoUtente.getEmail());

        //[...]

        return "redirect:/login";

    }

    @RequestMapping(value = "/login/registrazione", method = RequestMethod.POST)

    public String registUser(@ModelAttribute UtenteEntity infoUtente, HttpServletRequest request){

        //[...]

        UtenteEntity utente = utenteService.add(infoUtente.getEmail(), infoUtente.getPassword(), infoUtente.getNome());

        UtilityClass.salvaEmail(request.getSession(), infoUtente.getEmail());

        //[...]

        return "redirect:/login";

    }

}
