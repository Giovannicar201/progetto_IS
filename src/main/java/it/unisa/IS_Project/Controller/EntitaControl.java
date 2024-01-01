package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Exception.GAC.Logout.EmptySessionException;
import it.unisa.IS_Project.Model.Service.EntitaService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntitaControl {

    @Autowired
    public EntitaService entitaService;

    @RequestMapping(value = "/entità/creaEntità", method = RequestMethod.POST)

    public String creaEntita(@RequestBody String entity, HttpServletRequest request){
        try {
            String email = UtilityClass.emailSessione(request);
        } catch (EmptySessionException e) {
            throw new RuntimeException(e);
        }

        //entitaService.add()
        System.out.println(entity);

        return "gestoreentità";

    }

    @RequestMapping(value = "/entità/modificaEntità", method = RequestMethod.POST)

    public String modificaEntita(@ModelAttribute EntitaEntity entitaEntity){

        return "redirect:/login";

    }

    @RequestMapping(value = "/entità/eliminaEntità", method = RequestMethod.POST)

    public String eliminaEntita(@RequestBody String nomeEntita){
        entitaService.delete(nomeEntita);

        return "gestoreentità";
    }

    //STESSO DISCORSO DI GET LISTA IMMAGINI
    @RequestMapping(value = "/entità/getEntità", method = RequestMethod.POST)

    public String getListaEntita(@ModelAttribute EntitaEntity entitaEntity){

        return "redirect:/login";

    }
}

