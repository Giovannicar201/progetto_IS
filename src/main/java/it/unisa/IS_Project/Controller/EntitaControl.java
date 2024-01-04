package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.*;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.EliminazioneEntita.DeleteEntityException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.ModificaEntita.ModifyEntityException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.VisualizzaEntita.ViewEntityException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.VisualizzaListaEntita.ViewEntityListException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionEmailException;
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

    @RequestMapping(value = "/entità/creaEntità", method = RequestMethod.POST)

    public void creaEntita(@RequestBody String entita, HttpServletRequest request, HttpServletResponse response)
            throws CreateEntityException {

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

        } catch (ParseException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ PARSEEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (FolderNotFoundException e) {

            try {
                response.sendError(500, "MSEE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidEntityNameException e) {

            try {
                response.sendError(500, "IENE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidNumberOfPropertyException e) {

            try {
                response.sendError(500, "INPE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (NotUniqueEntityException e) {

            try {
                response.sendError(500, "NUEE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (ImageNotFoundException e) {

            try {
                response.sendError(500, "INFE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidCollisionException e) {

            try {
                response.sendError(500, "ICE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        }
    }

    @RequestMapping(value = "/entità/modificaEntità", method = RequestMethod.POST)

    public void modificaEntita(@RequestBody String entita, HttpServletRequest request, HttpServletResponse response) throws  ModifyEntityException {

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
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ PARSEEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (FolderNotFoundException e) {

            try {
                response.sendError(500, "MSEE");
            } catch (IOException ex) {
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidEntityNameException e) {

            try {
                response.sendError(500, "IENE");
            } catch (IOException ex) {
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidNumberOfPropertyException e) {

            try {
                response.sendError(500, "INPE");
            } catch (IOException ex) {
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (NotUniqueEntityException e) {

            try {
                response.sendError(500, "NUEE");
            } catch (IOException ex) {
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (ImageNotFoundException e) {

            try {
                response.sendError(500, "INFE");
            } catch (IOException ex) {
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidCollisionException e) {

            try {
                response.sendError(500, "ICE");
            } catch (IOException ex) {
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (EntityNotFoundException e) {

            try {
                response.sendError(500, "ENFE");
            } catch (IOException ex) {
                throw new ModifyEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        }

    }

    @RequestMapping(value = "/entità/eliminaEntità", method = RequestMethod.POST)

    public void eliminaEntita(@RequestBody String nome, HttpServletRequest request, HttpServletResponse response ) throws DeleteEntityException {

        try {

            SessionManager.getEmail(request);

            entitaService.eliminaEntita(nome);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new DeleteEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (EntityNotFoundException e) {

            try {
                response.sendError(500, "ENFE");
            } catch (IOException ex) {
                throw new DeleteEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        }

    }

    @RequestMapping(value = "/entità/visualizzaListaEntità", method = RequestMethod.POST)
    @ResponseBody

    public String visualizzaListaEntita(HttpServletRequest request, HttpServletResponse response )
            throws ViewEntityListException {

        String immagini = new JSONObject().toString();

        try {

            immagini = entitaService.visualizzaListaEntita(SessionManager.getEmail(request));

        }catch (SQLException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new ViewEntityListException("ERRORE - VISUALIZZA LISTA IMMAGINI SQLEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new ViewEntityListException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }
        }

        response.setContentType("text/plain");

        return immagini;
    }

    @RequestMapping(value = "/entità/visualizzaEntità", method = RequestMethod.POST)
    @ResponseBody

    public String visualizzaEntita(@RequestBody String nome, HttpServletRequest request, HttpServletResponse response ) throws ViewEntityException {
        String entita = new JSONObject().toString();

        try {

            SessionManager.getEmail(request);

            entita = entitaService.visualizzaEntita(nome);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new ViewEntityException("ERRORE - VISUALIZZA IMMAGINE IOEXCEPTION.");
            }

        } catch (EntityNotFoundException e) {

            try {
                response.sendError(500, "ENFE");
            } catch (IOException ex) {
                throw new ViewEntityException("ERRORE - VISUALIZZA IMMAGINE IOEXCEPTION.");
            }

        }

        response.setContentType("text/plain");

        return entita;
    }
}

