package it.unisa.IS_Project.Utility;

import it.unisa.IS_Project.Model.Exception.InexistentSessionException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilityClass {

    public String fetchJSONdataFromLocal(String url){

        return null;

    }

    public static void salvaEmail(HttpSession sessione, String email){

        sessione.setAttribute("email", email);

    }


    public static String emailSessione(HttpSession sessione){

        return (String) sessione.getAttribute("email");

    }
    public static String emailSessione(HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");

        if(email == null)
            throw new InexistentSessionException("Email not in session.");

        return email;
    }

    public static void salvaJsonMappa(HttpSession sessione, String json){

        sessione.setAttribute("mappa", json);

    }

    public static void salvaJsonPixelArt(HttpSession sessione, String json){

        sessione.setAttribute("pixelArt", json);

    }

    public static String mappaSessione(HttpSession sessione){

        return (String) sessione.getAttribute("mappa");

    }

    public static String pixelArtSessione(HttpSession sessione){

        return (String) sessione.getAttribute("pixelArt");

    }

    public static String cryptAlg(String string)
            throws NoSuchAlgorithmException {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] message = md.digest(string.getBytes());
            BigInteger no = new BigInteger(1, message);
            String cryptedString = no.toString();
            while(cryptedString.length() < 32){
                cryptedString = "0" + cryptedString;
            }
            return cryptedString;
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}


