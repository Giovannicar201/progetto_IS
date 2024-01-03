package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Exception.GAC.Login.LoginException;
import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagine.InvalidFileSizeException;
import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagine.UploadImageException;
import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Service.EntitaService;
import it.unisa.IS_Project.Utility.SessionManager;
import it.unisa.IS_Project.Utility.Utility;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EntitaControl {

    @Autowired
    public EntitaService entitaService;

    @RequestMapping(value = "/entità/creaEntità", method = RequestMethod.POST)

    public void creaEntita(@RequestBody String entita, HttpServletRequest request, HttpServletResponse response){

        JSONParser parser = new JSONParser();
        List<String> nomiProprieta = new ArrayList<>();
        List<String> valoriProprieta = new ArrayList<>();
        String email, nome, nomeImmagine, collisioni, nomeCartella;

        try {

            JSONObject entitaJSON = (JSONObject) parser.parse(entita);

            email = SessionManager.getEmail(request);
            nomeImmagine = (String) entitaJSON.get("nomeImmagine");
            nome = (String) entitaJSON.get("nome");
            collisioni = (String) entitaJSON.get("collisioni");
            nomeCartella = (String) entitaJSON.get("nomeCartella");

            JSONArray proprieta = (JSONArray) entitaJSON.get("proprieta");

            for(Object obj : proprieta) {
                JSONObject proprietaJSON = (JSONObject) obj;

                String nomeProprieta = (String) proprietaJSON.get("nomeProprieta");
                String valoreProprieta = (String) proprietaJSON.get("valoreProprieta");

                nomiProprieta.add(nomeProprieta);
                valoriProprieta.add(valoreProprieta);
            }

            entitaService.creaEntita(email,nomeImmagine,nome,collisioni,nomeCartella,nomiProprieta,valoriProprieta);

        } catch (NoSuchAlgorithmException | ParseException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new LoginException("ERRORE - NOSUCHALGORITHEXCEPTION || PARSEEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new UploadImageException("ERRORE - CARICA IMMAGINE IOEXCEPTION.");
            }

        } catch (InvalidFileSizeException e) {

            try {
                response.sendError(500, "IFSE");
            } catch (IOException ex) {
                throw new UploadImageException("ERRORE - DIMENSIONE DELL'IMMAGINE NON VALIDA.");
            }

        }
    }

    }

    /*

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

    }*/
}

