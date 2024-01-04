package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.MapSelectionException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.PixelArtSelectionException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;

@Controller
public class SelezioneControl {

    @RequestMapping(value = "/selezione/selezioneAreaMappa", method = RequestMethod.POST)

    public void selezioneAreaMappa(String selezione, HttpServletRequest request, HttpServletResponse response) throws MapSelectionException {

        try {

            SessionManager.getEmail(request);

            SessionManager.setSelezioneMappa(request,selezione);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new MapSelectionException("ERRORE - SELEZIONE MAPPA IOEXCEPTION.");
            }

        }

    }

    @RequestMapping(value = "/selezione/selezionePixelArt", method = RequestMethod.POST)

    public void selezioneAreaPixelArt(String selezione, HttpServletRequest request, HttpServletResponse response) throws PixelArtSelectionException {

        try {

            SessionManager.getEmail(request);

            SessionManager.setSelezioneMappa(request,selezione);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new PixelArtSelectionException("ERRORE - SELEZIONE PIXEL ART IOEXCEPTION.");
            }

        }

    }
}
