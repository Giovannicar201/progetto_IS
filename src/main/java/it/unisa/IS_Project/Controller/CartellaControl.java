package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Exception.GAC.Logout.EmailNotInSessionException;
import it.unisa.IS_Project.Model.Exception.InvalidFolderNameException;
import it.unisa.IS_Project.Model.Service.CartellaService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class CartellaControl {

    @Autowired
    public CartellaService cartellaService;

    @RequestMapping(value = "/griglia/creacartella", method = RequestMethod.POST)

    public String creaCartella(@RequestBody String nomeCartella, HttpServletRequest request, Model model) {

        try {

            String email = UtilityClass.emailSessione(request);
            cartellaService.creaCartella(nomeCartella, email);
        } catch (EmailNotInSessionException e) {

            model.addAttribute("error", "ERROR - YOU ARE NOT LOGGED.");

            return "LogInRegistrazione";

        } catch (InvalidFolderNameException e) {

            model.addAttribute("error", "ERROR - INVALID FOLDER NAME.");

            return "griglia";

        }

        return "griglia";

    }

    @RequestMapping(value = "/griglia/trovaCartelle", method = RequestMethod.GET)

    public String trovaCartelle(HttpServletRequest request, HttpServletResponse response, Model model) {
        JSONObject cartelleJSON = new JSONObject();
        JSONArray nomiCartelle = new JSONArray();
        List<CartellaEntity> cartelle;

        try {

            cartelle = cartellaService.getAllCartelle(UtilityClass.emailSessione(request));

        } catch (EmailNotInSessionException e) {

            model.addAttribute("error", "ERROR - YOU ARE NOT LOGGED.");

            return "LogInRegistrazione";
        }

        for(CartellaEntity cartellaEntity : cartelle) {
            JSONObject nomeCartella = new JSONObject();
            nomeCartella.put("nomeCartella",cartellaEntity.getNome());
        }

        cartelleJSON.put("nomiCartelle",nomiCartelle);

        response.setContentType("application/json");

        try {

            response.getWriter().append(cartelleJSON.toString());

        } catch (IOException e) {

            return "redirect:/error";

        }

        return "griglia";

    }
}
