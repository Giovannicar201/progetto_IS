package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagineException.UploadImageException;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.FolderCreationException;
import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagineException.InvalidFileSizeException;
import it.unisa.IS_Project.Model.Service.ImmagineService;
import it.unisa.IS_Project.Utility.SessionManager;
import it.unisa.IS_Project.Utility.Utility;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

    /*@RequestMapping(value = "/integraImmagine", method = RequestMethod.POST)

    public String integraPixelArt(@RequestPart("file") MultipartFile immagine, HttpServletRequest request) {
        byte byteArray[] = ImmDAO.doGetImm(request.getParameter("img"),
                request.getParameter("tipo"));
        response.setContentType("image/gif");
        OutputStream os = response.getOutputStream();
        os.write(byteArray);
        os.flush();
        os.close();
        return "gestoreentità";
    }*/

    @RequestMapping(value = "/gestoreImmagini/visualizzaListaImmagini", method = RequestMethod.GET)
    @ResponseBody

    public String visualizzaListaImmagini(HttpServletRequest request, HttpServletResponse response) {
        String immagini = new JSONObject().toString();

        try {

            immagini = immagineService.visualizzaListaImmagini(SessionManager.getEmail(request));

        }catch (SQLException e) {

            System.out.println("SQL");

        } catch (MissingSessionEmailException e) {

            System.out.println("NO EMAIL");
        }

        response.setContentType("text/plain");

        System.out.println(immagini);

        return immagini;
    }
}
