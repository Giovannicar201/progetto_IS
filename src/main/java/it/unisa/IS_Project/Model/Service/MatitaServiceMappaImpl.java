package it.unisa.IS_Project.Model.Service;

import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatitaServiceMappaImpl implements MatitaService{
    @Override
    @Transactional
    public void piazza(String mappa, String nome, String riga, String colonna) throws ParseException {

        JSONParser parser = new JSONParser();

        //is valid su riga e colonna

        JSONObject mappaJSON = (JSONObject) parser.parse(mappa);

        JSONArray entita = (JSONArray) mappaJSON.get("mappa");

        for (Object entitaOBJ : entita) {
            JSONObject entitaJSON = (JSONObject) entitaOBJ;

            if(entitaJSON.get("riga") == riga && entitaJSON.get("colonna") == colonna)
                entitaJSON.put("nome",nome);
        }

        //vanno messe le coordinate all'entita
    }

    @Override
    @Transactional
    public void riempi(String mappa, String nomi) {

    }
}
