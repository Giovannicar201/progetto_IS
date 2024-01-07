package it.unisa.IS_Project.Controller.GEN.GEN;

import it.unisa.IS_Project.Exception.GEN.GEN.CreazioneEntita.*;
import it.unisa.IS_Project.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Exception.GEN.GEN.GENException;
import it.unisa.IS_Project.Exception.GEN.GEN.ImageAlreadyUsedException;
import it.unisa.IS_Project.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Service.EntitaService;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EntitaControl {

    @Autowired
    public EntitaService entitaService;

    @RequestMapping(value = "/gestoreEntita/creaEntità", method = RequestMethod.POST)

    public void creaEntita(@RequestBody String entita, HttpServletRequest request, HttpServletResponse response) throws GENException {

        JSONParser parser = new JSONParser();
        List<String> nomiProprieta = new ArrayList<>();
        List<String> valoriProprieta = new ArrayList<>();

        try {

            JSONObject entitaJSON = (JSONObject) parser.parse(entita);

            String email = SessionManager.getEmail(request);
            String nomeImmagine = (String) entitaJSON.get("nomeImmagine");
            String nome = (String) entitaJSON.get("nome");
            String collisioni = (String) entitaJSON.get("collisioni");
            String nomeCartella = (String) entitaJSON.get("nomeCartella");

            JSONArray proprieta = (JSONArray) entitaJSON.get("proprieta");

            for(Object obj : proprieta) {
                JSONObject proprietaJSON = (JSONObject) obj;

                String nomeProprieta = (String) proprietaJSON.get("nomeProprieta");
                String valoreProprieta = (String) proprietaJSON.get("valoreProprieta");

                nomiProprieta.add(nomeProprieta);
                valoriProprieta.add(valoreProprieta);
            }

            entitaService.creaEntita(email,nomeImmagine,nome,collisioni,nomeCartella,nomiProprieta,valoriProprieta);

        } catch (ParseException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - PARSEEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        } catch (FolderNotFoundException e) {

            try {
                response.sendError(500, "MSEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - CARTELLA NON ESISTENTE.");
            }

        } catch (InvalidEntityNameException e) {

            try {
                response.sendError(500, "IENE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NOME NON VALIDO.");
            }

        } catch (InvalidNumberOfPropertyException e) {

            try {
                response.sendError(500, "INPE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NUMERO DI PROPRIETÀ NON VALIDO.");
            }

        } catch (NotUniqueEntityException e) {

            try {
                response.sendError(500, "NUEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - ENTITÀ GIÀ ESISTENTE.");
            }

        } catch (ImageNotFoundException e) {

            try {
                response.sendError(500, "INFE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - IMMAGINE NON ESISTENTE.");
            }

        } catch (InvalidCollisionException e) {

            try {
                response.sendError(500, "ICE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - COLLISIONI NON VALIDE.");
            }

        } catch (ImageAlreadyUsedException e) {

            try {
                response.sendError(500, "IAUE");
            } catch (IOException ex) {
                throw new GENException("\"ERRORE - IMMAGINE GIÀ USATA.");
            }

        }
    }

    @RequestMapping(value = "/gestoreEntita/modificaEntità", method = RequestMethod.POST)

    public void modificaEntita(@RequestBody String entita, HttpServletRequest request, HttpServletResponse response) throws GENException {

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

            entitaService.modificaEntita(email,nomeImmagine,nome,collisioni,nomeCartella,nomiProprieta,valoriProprieta);

        } catch (ParseException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - PARSEEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        } catch (FolderNotFoundException e) {

            try {
                response.sendError(500, "MSEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - CARTELLA NON ESISTENTE.");
            }

        } catch (InvalidEntityNameException e) {

            try {
                response.sendError(500, "IENE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NOME NON VALIDO.");
            }

        } catch (InvalidNumberOfPropertyException e) {

            try {
                response.sendError(500, "INPE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NUMERO DI PROPRIETÀ NON VALIDO.");
            }

        } catch (NotUniqueEntityException e) {

            try {
                response.sendError(500, "NUEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - ENTITÀ GIÀ ESISTENTE.");
            }

        } catch (ImageNotFoundException e) {

            try {
                response.sendError(500, "INFE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - IMMAGINE NON ESISTENTE.");
            }

        } catch (InvalidCollisionException e) {

            try {
                response.sendError(500, "ICE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - COLLISIONI NON VALIDE.");
            }

        }
    }

    @RequestMapping(value = "/gestoreEntita/eliminaEntità", method = RequestMethod.POST)

    public void eliminaEntita(@RequestBody String nome, HttpServletRequest request, HttpServletResponse response ) throws GENException {

        try {

            String email = SessionManager.getEmail(request);

            entitaService.eliminaEntita(nome,email);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        } catch (EntityNotFoundException e) {

            try {
                response.sendError(500, "ENFE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - ENTITÀ NON ESISTENTE.");
            }

        }

    }

    @RequestMapping(value = "/gestoreEntita/visualizzaListaEntità", method = RequestMethod.POST)
    @ResponseBody

    public String visualizzaListaEntita(HttpServletRequest request, HttpServletResponse response ) throws GENException {

        String immagini = new JSONObject().toString();

        try {

            immagini = entitaService.visualizzaListaEntita(SessionManager.getEmail(request));

        }catch (SQLException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - SQL EXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }
        }

        response.setContentType("text/plain");

        return immagini;
    }

    @RequestMapping(value = "/gestoreEntita/visualizzaEntità", method = RequestMethod.POST)
    @ResponseBody

    public String visualizzaEntita(@RequestBody String nome, HttpServletRequest request, HttpServletResponse response ) throws GENException {

        String entita = new JSONObject().toString();

        try {

            String email = SessionManager.getEmail(request);

            entita = entitaService.visualizzaEntita(nome,email);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        } catch (EntityNotFoundException e) {

            try {
                response.sendError(500, "ENFE");
            } catch (IOException ex) {
                throw new GENException("ERRORE - ENTITÀ NON ESISTENTE.");
            }

        }

        response.setContentType("text/plain");

        return entita;
    }
}

