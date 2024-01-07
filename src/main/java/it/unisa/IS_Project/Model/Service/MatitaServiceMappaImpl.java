package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CoordinateEntity;
import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Exception.GMP.GST.InvalidRowException;
import it.unisa.IS_Project.Exception.GMP.GST.Selezione.InvalidColumnException;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@Service
public class MatitaServiceMappaImpl implements MatitaService {

    @Autowired
    private EntitaService entitaService;

    @Override
    @Transactional
    public String piazza(String email, String mappa, String nome, String riga, String colonna) throws ParseException, EntityNotFoundException, InvalidColumnException, InvalidRowException, SQLException {

        EntitaEntity entitaEntityQuery = entitaService.get(nome,email);

        JSONParser parser = new JSONParser();

        if(entitaEntityQuery == null)
            throw new EntityNotFoundException("ERRORE - ENTITA NON ESISTENTE.");

        if(!Validator.isRowValidMOCK(riga))
            throw new InvalidRowException("ERRORE - RIGA NON VALIDA.");

        if(!Validator.isColumnValidMOCK(colonna))
            throw new InvalidColumnException("ERRORE - COLONNA NON VALIDA.");

        JSONObject mappaJSON = (JSONObject) parser.parse(mappa);

        JSONArray entita = (JSONArray) mappaJSON.get("mappa");

        for (Object entitaOBJ : entita) {
            JSONObject entitaJSON = (JSONObject) entitaOBJ;

            if(((String)entitaJSON.get("riga")).compareTo(riga) == 0 &&
                    ((String)entitaJSON.get("colonna")).compareTo(colonna) == 0) {

                entitaJSON.put("id",entitaEntityQuery.getId());

                Blob immagine = entitaEntityQuery.getImmagineEntity().getImmagine();
                byte[] bytes = immagine.getBytes(1, (int) immagine.length());

                entitaJSON.put("immagine",Base64.getEncoder().encodeToString(bytes));
            }
        }

        mappaJSON.put("mappa",entita);

        CoordinateEntity coordinateEntity = new CoordinateEntity();

        coordinateEntity.setPrimaryKeyCoordinate(new CoordinateEntity.PrimaryKeyCoordinate(riga,colonna,entitaEntityQuery.getId()));

        return mappaJSON.toString();
    }

    @Override
    @Transactional
    public void riempi(String mappa, List<String> nomi) {

    }

    @Override
    @Transactional
    public String visualizzaLista(String email, String nome) throws SQLException {
        return entitaService.visualizzaListaEntitaInCartella(email,nome);
    }
}
