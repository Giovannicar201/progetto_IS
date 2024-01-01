package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Exception.GAC.Logout.EmptySessionException;
import it.unisa.IS_Project.Model.Exception.InvalidFolderNameException;
import it.unisa.IS_Project.Model.Service.CartellaService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CartellaControl {

    @Autowired
    public CartellaService cartellaService;

    @RequestMapping(value = "/griglia/creacartella", method = RequestMethod.POST)

    public String creaCartella(@RequestBody String nomeCartella, HttpServletRequest request) {

        String email = " ";

        try {
            email = UtilityClass.emailSessione(request);
        } catch (EmptySessionException e) {
            // TO DO
        }

        try {
            cartellaService.creaCartella(nomeCartella, email);
        } catch (InvalidFolderNameException e) {
            // TO DO
        }

        return "gestoreentità";

    }

    @RequestMapping(value = "/griglia/trovaCartelle", method = RequestMethod.GET)

    public String trovaCartelle(HttpServletRequest request) {

        try {
            List<CartellaEntity> cartelle = cartellaService.getAllCartelle(UtilityClass.emailSessione(request));
        } catch (EmptySessionException e) {
            throw new RuntimeException(e);
        }

        return "griglia";

    }
}
