package it.unisa.IS_Project.Controller.GMP.GST;

import it.unisa.IS_Project.Exception.GMP.GMP.GMPException;
import it.unisa.IS_Project.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;

@Controller
public class SelezioneControl {

    @RequestMapping(value = "/selezione/selezioneAreaMappa", method = RequestMethod.POST)

    public void selezioneAreaMappa(@RequestBody String selezione, HttpServletRequest request, HttpServletResponse response) throws GMPException {

        try {

            SessionManager.getEmail(request);

            SessionManager.setSelezioneMappa(request,selezione);

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new GMPException("ERRORE - NESSUN UTENTE IN SESSIONE.");
            }

        }

    }

    @RequestMapping(value = "/selezione/selezionePixelArt", method = RequestMethod.POST)

    public void selezioneAreaPixelArt(String selezione, HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {

            SessionManager.getEmail(request);

            SessionManager.setSelezioneMappa(request,selezione);

        } catch (MissingSessionEmailException e) {

                response.sendError(302, "MSEE");

        }

    }
}
