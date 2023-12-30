package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventoControl {

    @Autowired
    public EventoService eventoService;

    @RequestMapping(value = "/eventi/creaEvento", method = RequestMethod.POST)

    public String creaEvento(@RequestBody String evento){

        System.out.println(evento);

        return "eventmanager";

    }

    public String visualizzaAnteprima(@ModelAttribute EventoEntity eventoEntity){

        return "redirect:/login";

    }

    public String eliminaEvento(@ModelAttribute EventoEntity eventoEntity){

        return "redirect:/login";

    }

    public String getListaEventi(@ModelAttribute EventoEntity eventoEntity){

        return "redirect:/login";

    }
}
