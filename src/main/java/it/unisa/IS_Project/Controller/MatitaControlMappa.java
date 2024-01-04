package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.InvalidRowException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.InvalidColumnException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionMapException;
import it.unisa.IS_Project.Model.Service.MatitaServiceMappaImpl;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MatitaControlMappa extends MatitaControl {

    @RequestMapping(value = "/matita/piazzaEntita", method = RequestMethod.POST)

    @Override
    public void piazza(@RequestBody String entita, HttpServletRequest request, HttpServletResponse response) {

        JSONParser parser = new JSONParser();
        String nome, riga, colonna;

        try {

            JSONObject entitaJSON = (JSONObject) parser.parse(entita);

            SessionManager.getEmail(request);

            nome = (String) entitaJSON.get("nome");
            riga = (String) entitaJSON.get("riga");
            colonna = (String) entitaJSON.get("colonna");

            MatitaServiceMappaImpl matitaServiceMappa = (MatitaServiceMappaImpl) matitaService;

            String mappa = matitaServiceMappa.piazza(SessionManager.getMappa(request),nome,riga,colonna);

            SessionManager.setMappa(request,mappa);

        } catch (ParseException | SQLException e) {
            //TO DO
        } catch (MissingSessionMapException e) {
            throw new RuntimeException(e);
        } catch (MissingSessionEmailException e) {
            throw new RuntimeException(e);
        } catch (InvalidColumnException e) {
            throw new RuntimeException(e);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvalidRowException e) {
            throw new RuntimeException(e);
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

    public String visualizzaListaEntitaInCartella(@RequestBody String nome, HttpServletRequest request,
                                                  HttpServletResponse response) {

        JSONParser parser = new JSONParser();

        String email = null, nomeCartella;

        try {

            email = SessionManager.getEmail(request);

            JSONObject nomeJSON = (JSONObject) parser.parse(nome);

            nomeCartella = (String) nomeJSON.get("nome");

            matitaService = new MatitaServiceMappaImpl();

            return matitaService.visualizzaLista(email,nomeCartella);

        } catch (MissingSessionEmailException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
