package it.unisa.IS_Project.Model.Service;

import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MatitaServicePixelArtImpl implements MatitaService {
    @Autowired
    private EntitaService entitaService;

    @Override
    @Transactional
    public String piazza(String email, String pixelArt, String esadecimale, String riga, String colonna)
            throws ParseException {

        JSONParser parser = new JSONParser();
        return null;
    }

    @Override
    @Transactional
    public void riempi(String mappa, List<String> esadecimali) {

    }

    @Override
    public String visualizzaLista(String email, String string) throws SQLException {
        return null;
    }
}
