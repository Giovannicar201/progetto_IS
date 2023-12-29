package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtenteController {
    @Autowired
    public UtenteService utenteService;

    @RequestMapping(value = "/login/login", method = RequestMethod.POST)

    public String loginUser(@ModelAttribute UtenteEntity infoUtente){

        return "/login";

    }

    @RequestMapping(value = "/login/registrazione", method = RequestMethod.POST)

    public String registUser(@ModelAttribute UtenteEntity infoUtente){

        UtenteEntity utente = utenteService.add(infoUtente.getEmail(), infoUtente.getPassword(), infoUtente.getNome());

        return "redirect:/login";

    }

}
