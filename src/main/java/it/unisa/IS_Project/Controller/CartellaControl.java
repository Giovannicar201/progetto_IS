package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Exception.InexistentSessionException;
import it.unisa.IS_Project.Model.Service.CartellaService;
import it.unisa.IS_Project.Model.Service.EventoService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CartellaControl {

    @RequestMapping(value = "/griglia/creacartella", method = RequestMethod.POST)

    public String creaCartella(@RequestBody String nomeCartella, HttpServletRequest request) {

        String email = UtilityClass.emailSessione(request);

        cartellaService.add(nomeCartella, email);

        return "griglia";

    }

    @RequestMapping(value = "/griglia/trovaCartelle", method = RequestMethod.GET)

    public String trovaCartelle(HttpServletRequest request) {

        List<CartellaEntity> cartelle = cartellaService.getAllCartelle(UtilityClass.emailSessione(request));

        return "griglia";

    }

    @Autowired
    public CartellaService cartellaService;

}
