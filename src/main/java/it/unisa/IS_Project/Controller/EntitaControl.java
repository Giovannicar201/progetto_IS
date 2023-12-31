package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
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
        String email = UtilityClass.emailSessione(request);

        entitaService.add()
        //System.out.println(entity);

        return "gestoreentità";

    }

    public String modificaEntita(@ModelAttribute EntitaEntity entitaEntity){

        return "redirect:/login";

    }

    public String eliminaEntita(@RequestBody String nomeEntita){
        entitaService.delete(nomeEntita);

        return "gestoreentità";
    }

    public String getListaEntita(@ModelAttribute EntitaEntity entitaEntity){

        return "redirect:/login";

    }
}

