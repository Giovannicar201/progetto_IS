package it.unisa.IS_Project.Model.Controller.FormDataController;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j

public class FormDataController {

    @RequestMapping(value = "/registrazione", method = RequestMethod.POST)

    public String createUser(@ModelAttribute UtenteEntity infoUtente){

        log.info("utente creato");

        return "redirect:/login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String loginUser(@ModelAttribute UtenteEntity infoUtente){

        log.info("accesso eseguito");

        return "redirect:/login";

    }

}
