package it.unisa.IS_Project.Controller.GMP.GST;

import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Model.Exception.GMP.GMP.GMPException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.GSTException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.InvalidRowException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.InvalidColumnException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionMapException;
import it.unisa.IS_Project.Model.Service.MatitaService;
import it.unisa.IS_Project.Model.Service.MatitaServiceMappaImpl;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class MatitaMappaControl extends MatitaControl {

    @Qualifier("matitaServiceMappaImpl")
    @Autowired
    protected MatitaService matitaService;

    @RequestMapping(value = "/matita/piazzaEntita", method = RequestMethod.POST)

    @Override
    public void piazza(@RequestBody String entita, HttpServletRequest request, HttpServletResponse response) throws GSTException {

        JSONParser parser = new JSONParser();

        try {

            JSONObject entitaJSON = (JSONObject) parser.parse(entita);

            String email = SessionManager.getEmail(request);
            String mappa = SessionManager.getMappa(request);
            String nome = (String) entitaJSON.get("nome");
            String riga = (String) entitaJSON.get("riga");
            String colonna = (String) entitaJSON.get("colonna");

            String mappaModificata = matitaService.piazza(email,mappa,nome,riga,colonna);

            SessionManager.setMappa(request,mappaModificata);

        } catch (ParseException | SQLException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new GSTException("ERRORE - PARSEEXCEPTION || SQLEXCEPTION.");
            }

        } catch (MissingSessionMapException e) {

            try {
                response.sendError(302, "MSME");
            } catch (IOException ex) {
                throw new GSTException("ERRORE - NESSUNA MAPPA IN SESSIONE.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GSTException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        } catch (InvalidColumnException e) {

            try {
                response.sendError(500, "ICE");
            } catch (IOException ex) {
                throw new GSTException("ERRORE - COLONNA NON VALIDA.");
            }

        } catch (EntityNotFoundException e) {

            try {
                response.sendError(500, "ENFE");
            } catch (IOException ex) {
                throw new GSTException("ERRORE - ENTITA NON ESISTENTE.");
            }

        } catch (InvalidRowException e) {

            try {
                response.sendError(500, "IRE");
            } catch (IOException ex) {
                throw new GSTException("ERRORE - RIGA NON VALIDA.");
            }

        }
    }

    @RequestMapping(value = "/matita/riempiConEntita", method = RequestMethod.POST)

    @Override
    public void riempi(@RequestBody String nomi, HttpServletRequest request, HttpServletResponse response) {

        MatitaServiceMappaImpl matitaServiceMappa = (MatitaServiceMappaImpl) matitaService;

        //matitaServiceMappa.piazza(SessionManager.getMappa(request),nomi);

    }

    @RequestMapping(value = "/matita/visualizzaListaEntitaInCartella", method = RequestMethod.POST)
    @ResponseBody

    public String visualizzaListaEntitaInCartella(@RequestBody String nome, HttpServletRequest request, HttpServletResponse response) throws GSTException {

        JSONParser parser = new JSONParser();

        try {

            String email = SessionManager.getEmail(request);

            JSONObject nomeJSON = (JSONObject) parser.parse(nome);

            String nomeCartella = (String) nomeJSON.get("nome");

            return matitaService.visualizzaLista(email,nomeCartella);

        } catch (ParseException | SQLException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new GSTException("ERRORE - PARSEEXCEPTION || SQLEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GSTException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        }

        return null;
    }
}
