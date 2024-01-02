package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagineException.InvalidFileSizeException;
import it.unisa.IS_Project.Model.Service.ImmagineService;
import it.unisa.IS_Project.Utility.SessionManager;
import it.unisa.IS_Project.Utility.Utility;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class ImmagineControl {
    @Autowired
    public ImmagineService immagineService;
    @RequestMapping(value = "/caricaImmagine", method = RequestMethod.POST)

    public String caricaImmagine(@RequestPart("file") MultipartFile immagine, HttpServletRequest request) {
        String email = "";

        //AL MOMENTO ANCHE SE NON STA NESSUNO IN SESSIONE SALVA LO STESSO

        try {
            email = SessionManager.getEmail(request);
        } catch (MissingSessionEmailException e) {
            // TO DO
        }

        try {
            immagineService.caricaImmagine(immagine,email);
        } catch (SQLException e) {
            // TO DO
        } catch (IOException e) {
            // TO DO
        } catch (InvalidFileSizeException e) {
            // TO DO
        }

        //chiami il metodo che prende tutte le immagini e le restituisci lato js

        return "gestoreentità";
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
    }

    @RequestMapping(value = "/visualizzaListaImmagini", method = RequestMethod.POST)

    public String visualizzaListaImmagini(HttpServletRequest request) {
        byte byteArray[] = ImmDAO.doGetImm(request.getParameter("img"),
                request.getParameter("tipo"));
        response.setContentType("image/gif");
        OutputStream os = response.getOutputStream();
        os.write(byteArray);
        os.flush();
        os.close();
        return "gestoreentità";
    }*/
}
