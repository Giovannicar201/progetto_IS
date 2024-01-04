package it.unisa.IS_Project.Utility;

import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.Session.MissingSessionMapException;
import jakarta.servlet.http.HttpServletRequest;

public class SessionManager {
    public static void setEmail(HttpServletRequest request, String email) {

        request.getSession().setAttribute("email", email);

    }

    public static String getEmail(HttpServletRequest request) throws MissingSessionEmailException {
        String email = (String) request.getSession().getAttribute("email");

        if(email == null)
            throw new MissingSessionEmailException("ERRORE - NESSUN UTENTE IN SESSIONE.");

        return email;
    }

    public static void setMappa(HttpServletRequest request, String mappa) {

        request.getSession().setAttribute("mappa", mappa);

    }

    public static String getMappa(HttpServletRequest request) throws MissingSessionMapException {
        String mappa = (String) request.getSession().getAttribute("mappa");

        if(mappa == null)
            throw new MissingSessionMapException("ERRORE - NESSUNA MAPPA IN SESSIONE.");

        return mappa;
    }
}
