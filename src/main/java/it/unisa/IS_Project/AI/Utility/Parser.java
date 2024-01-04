package it.unisa.IS_Project.AI.Utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {

    public static int[][] convertiMappa(String mappa) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject mappaJSON = (JSONObject) parser.parse(mappa);

        JSONArray entita = (JSONArray) mappaJSON.get("mappa");

        JSONObject entitaJSON = (JSONObject) entita.get(entita.size() - 1);

        int altezza = Math.toIntExact((Long) entitaJSON.get("riga")) + 1;
        int larghezza = Math.toIntExact((Long) entitaJSON.get("colonna")) + 1;

        int[][] matriceMappa = new int[altezza][larghezza];

        for (Object obj : entita) {
            entitaJSON = (JSONObject) obj;

            int riga = Math.toIntExact((Long) entitaJSON.get("riga"));
            int colonna = Math.toIntExact((Long) entitaJSON.get("colonna"));
            int id = Math.toIntExact((Long) entitaJSON.get("id"));

            matriceMappa[riga][colonna] = id;
        }

        return matriceMappa;
    }
}
