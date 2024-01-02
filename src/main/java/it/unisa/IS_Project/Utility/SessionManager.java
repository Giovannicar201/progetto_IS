package it.unisa.IS_Project.Utility;

import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
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
}