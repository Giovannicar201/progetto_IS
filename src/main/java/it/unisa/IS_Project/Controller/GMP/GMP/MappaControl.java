package it.unisa.IS_Project.Controller.GMP.GMP;

import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapHeightException;
import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapNameException;
import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapWidthException;
import it.unisa.IS_Project.Exception.GMP.GMP.GMPException;
import it.unisa.IS_Project.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Exception.Sessione.MissingSessionMapException;
import it.unisa.IS_Project.Model.Service.MappaService;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;

@Controller
public class MappaControl {

    @Autowired
    public MappaService mappaService;

    @RequestMapping(value = "/gestoreMappa/creaMappa", method = RequestMethod.POST)

    public void creaMappa(@RequestBody String mappa, HttpServletRequest request, HttpServletResponse response) throws GMPException {

        JSONParser parser = new JSONParser();

        try {

            String email = SessionManager.getEmail(request);

            JSONObject mappaJSON = (JSONObject) parser.parse(mappa);

            String nome = (String) mappaJSON.get("nome");
            String altezza = (String) mappaJSON.get("altezza");
            String larghezza = (String) mappaJSON.get("larghezza");

            System.out.println(altezza + " " + larghezza);

            String mappaVuota = mappaService.creaMappa(email,nome,altezza,larghezza);

            SessionManager.setMappa(request,mappaVuota);

            try {
                System.out.println(SessionManager.getMappa(request));
            } catch (MissingSessionMapException e) {
                throw new RuntimeException(e);
            }

        } catch (ParseException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new GMPException("ERRORE - PARSEEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GMPException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        } catch (InvalidMapWidthException e) {

            try {
                response.sendError(500, "IMWE");
            } catch (IOException ex) {
                throw new GMPException("ERRORE - LARGHEZZA NON VALIDA.");
            }

        } catch (InvalidMapHeightException e) {

            try {
                response.sendError(500, "IMHE");
            } catch (IOException ex) {
                throw new GMPException("ERRORE - ALTEZZA NON VALIDA.");
            }

        } catch (InvalidMapNameException e) {

            try {
                response.sendError(500, "IMNE");
            } catch (IOException ex) {
                throw new GMPException("ERRORE - NOME NON VALIDO.");
            }

        }
    }

    @RequestMapping(value = "/gestoreMappa/visualizzaStatisticheMappa", method = RequestMethod.POST)
    @ResponseBody

    public String visualizzaStatisticheMappa(HttpServletRequest request, HttpServletResponse response)
            throws GMPException {

        /*String statistiche = new JSONObject().toString();

        try {

            SessionManager.getEmail(request);

            statistiche = mappaService.visualizzaStatisticheMappa(SessionManager.getMappa(request));

        }catch (SQLException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new ViewMapStatsException("ERRORE - VISUALIZZA STATISTICHE MAPPA SQLEXCEPTION.");
            }

        } catch (MissingSessionMapException e) {

            try {
                response.sendError(302, "MSME");
            } catch (IOException ex) {
                throw new ViewMapStatsException("ERRORE - VISUALIZZA STATISTICHE MAPPA IOEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new ViewMapStatsException("ERRORE - VISUALIZZA STATISTICHE MAPPA IOEXCEPTION.");
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        response.setContentType("text/plain");

        return statistiche;*/
        return null;
    }

    @RequestMapping(value = "/gestoreMappa/salvaMappa", method = RequestMethod.POST)

    public void salvaMappa(HttpServletRequest request, HttpServletResponse response) {

        /*JSONParser parser = new JSONParser();
        String email, mappa;

        try {

            email = SessionManager.getEmail(request);
            mappa = SessionManager.getMappa(request);

            mappaService.salvaMappa(mappa);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (MissingSessionEmailException e) {
            throw new RuntimeException(e);
        } catch (MissingSessionMapException e) {
            throw new RuntimeException(e);
        }*/
    }

    @RequestMapping(value = "/gestoreMappa/recuperaMappa", method = RequestMethod.POST)
    @ResponseBody

    public String caricaMappa(HttpServletRequest request, HttpServletResponse response) throws GMPException {

        String mappa = new JSONObject().toString();

        try {

            SessionManager.getEmail(request);

            mappa = SessionManager.getMappa(request);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GMPException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        } catch (MissingSessionMapException e) {

            try {
                response.sendError(302, "MSME");
            } catch (IOException ex) {
                throw new GMPException("ERRORE - NESSUNA MAPPA IN SESSIONE.");
            }

        }

        response.setContentType("text/plain");

        return mappa;
    }
}
