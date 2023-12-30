package it.unisa.IS_Project.Utility;

import jakarta.servlet.http.HttpSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

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

}


