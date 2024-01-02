package it.unisa.IS_Project.Utility;

import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utility {

    public String fetchJSONdataFromLocal(String url){

        return null;

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

    public static String encrypt(String string) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] message = md.digest(string.getBytes());
        BigInteger no = new BigInteger(1, message);
        String cryptedString = no.toString();

        while(cryptedString.length() < 32){
            cryptedString = "0" + cryptedString;
        }

        return cryptedString;
    }

}


