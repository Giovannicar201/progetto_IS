package it.unisa.IS_Project.Controller.FormDataController;

import it.unisa.IS_Project.Model.Model.UtenteModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j

public class FormDataController {

    @RequestMapping(value = "/registrazione", method = RequestMethod.POST)

    public String createUser(@ModelAttribute UtenteModel infoUtente){

        log.info("utente creato");

        return "redirect:/login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String loginUser(@ModelAttribute UtenteModel infoUtente){

        log.info("accesso eseguito");

        return "redirect:/login";

    }

}