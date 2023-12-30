package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Service.EntitaService;
import it.unisa.IS_Project.Model.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntitaControl {

    @Autowired
    public EntitaService entitaService;

    @RequestMapping(value = "/entità/creaEntità", method = RequestMethod.POST)

    public String creaEntita(@ModelAttribute EntitaEntity entitaEntity){

        System.out.println("test 1");

        return "gestoreentità";

    }

    public String modificaEntita(@ModelAttribute EntitaEntity entitaEntity){

        return "redirect:/login";

    }

    public String eliminaEntita(@ModelAttribute EntitaEntity entitaEntity){

        return "redirect:/login";

    }

    public String getListaEntita(@ModelAttribute EntitaEntity entitaEntity){

        return "redirect:/login";

    }
}

