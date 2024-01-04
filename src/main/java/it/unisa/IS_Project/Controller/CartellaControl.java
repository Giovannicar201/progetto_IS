package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.FolderCreationException;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.VisualizzaListaCartelle.VisualizzaListaCartelleException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.InvalidFolderNameException;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.NotUniqueFolderException;
import it.unisa.IS_Project.Model.Service.CartellaService;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;


@Controller
public class CartellaControl {

    @Autowired
    public CartellaService cartellaService;

    @RequestMapping(value = "/gestoreCartelle/creaCartella", method = RequestMethod.POST)

    public void creaCartella(@RequestBody String nomeCartella, HttpServletRequest request, HttpServletResponse response) throws FolderCreationException {

        try {

            String email = SessionManager.getEmail(request);

            cartellaService.creaCartella(nomeCartella, email);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new FolderCreationException("ERRORE - CREA CARTELLA IOEXCEPTION.");
            }

        } catch (InvalidFolderNameException e) {

            try {
                response.sendError(500, "IFNE");
            } catch (IOException ex) {
                throw new FolderCreationException("ERRORE - CREA CARTELLA IOEXCEPTION.");
            }

        } catch (NotUniqueFolderException e) {

            try {
                response.sendError(500, "NUFE");
            } catch (IOException ex) {
                throw new FolderCreationException("ERRORE - CREA CARTELLA IOEXCEPTION.");
            }

        }
    }

    @RequestMapping(value = "/gestoreCartelle/visualizzaListaCartelle", method = RequestMethod.GET)
    @ResponseBody

    public String visualizzaListaCartelle(HttpServletRequest request, HttpServletResponse response) throws VisualizzaListaCartelleException {
        String nomiCartelle = new JSONObject().toString();

        try {

            nomiCartelle = cartellaService.visualizzaListaCartelle(SessionManager.getEmail(request));

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new VisualizzaListaCartelleException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            };
        }

        response.setContentType("text/plain");

        return nomiCartelle;
    }
}
