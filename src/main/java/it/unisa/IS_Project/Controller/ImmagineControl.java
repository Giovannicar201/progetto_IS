package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagine.UploadImageException;
import it.unisa.IS_Project.Model.Exception.GEN.GIM.VisualizzaListaImmagini.ViewImagesListException;
import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagine.InvalidFileSizeException;
import it.unisa.IS_Project.Model.Service.ImmagineService;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class ImmagineControl {
    @Autowired
    public ImmagineService immagineService;
    @RequestMapping(value = "/gestoreImmagini/caricaImmagine", method = RequestMethod.POST)

    public void caricaImmagine(@RequestPart("file") MultipartFile immagine, HttpServletRequest request, HttpServletResponse response) throws UploadImageException {

        try {

            String email = SessionManager.getEmail(request);

            immagineService.caricaImmagine(immagine, email);

        } catch (IOException | SQLException e) {

            throw new UploadImageException("ERRORE - CARICA IMMAGINE IOEXCEPTION || SQLEXCEPTION.");

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

    @RequestMapping(value = "/gestoreImmagini/integraImmagine", method = RequestMethod.POST)

    public void integraPixelArt(@RequestPart("file") MultipartFile immagine, HttpServletRequest request, HttpServletResponse response) throws UploadImageException {

        //SE LATO JS SI SETTA IL NOME DELL'IMMAGINE POSSIAMO FARE UN UNICO METODO
        //NEL CASO VA RIPORTATO QUESTO CAMBIAMENTO NELL'ODD

        try {

            String email = SessionManager.getEmail(request);

            immagineService.caricaImmagine(immagine, email);

        } catch (IOException | SQLException e) {

            throw new UploadImageException("ERRORE - CARICA IMMAGINE IOEXCEPTION || SQLEXCEPTION.");

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

    @RequestMapping(value = "/gestoreImmagini/visualizzaListaImmagini", method = RequestMethod.GET)
    @ResponseBody

    public String visualizzaListaImmagini(HttpServletRequest request, HttpServletResponse response) throws ViewImagesListException {
        String immagini = new JSONObject().toString();

        try {

            immagini = immagineService.visualizzaListaImmagini(SessionManager.getEmail(request));

        }catch (SQLException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new ViewImagesListException("ERRORE - VISUALIZZA LISTA IMMAGINI SQLEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new ViewImagesListException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }
        }

        response.setContentType("text/plain");

        return immagini;
    }
}
