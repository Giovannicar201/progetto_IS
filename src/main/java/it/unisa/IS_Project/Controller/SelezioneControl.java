package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.MapSelectionException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.PixelArtSelectionException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionMapSelectionException;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;

@Controller
public class SelezioneControl {

    @RequestMapping(value = "/selezione/selezioneAreaMappa", method = RequestMethod.POST)

    public void selezioneAreaMappa(@RequestBody String selezione, HttpServletRequest request, HttpServletResponse response)
            throws MapSelectionException {

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

            JSONObject selezioneJSON = new JSONObject();

            selezioneJSON.put("primaRiga","0");
            selezioneJSON.put("primaColonna","0");
            selezioneJSON.put("secondaRiga","6");
            selezioneJSON.put("secondaColonna","6");

            SessionManager.setSelezioneMappa(request,selezioneJSON.toString());

            System.out.println(SessionManager.getSelezioneMappa(request));

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new PixelArtSelectionException("ERRORE - SELEZIONE PIXEL ART IOEXCEPTION.");
            }

        } catch (MissingSessionMapSelectionException e) {
            throw new RuntimeException(e);
        }

    }
}
