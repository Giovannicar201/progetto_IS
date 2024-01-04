package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CoordinateEntity;
import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.InvalidRowException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.InvalidColumnException;
import it.unisa.IS_Project.Utility.SessionManager;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatitaServiceMappaImpl implements MatitaService{
    @Autowired
    private EntitaService entitaService;

    @Override
    @Transactional
    public void piazza(String mappa, String nome, String riga, String colonna) throws ParseException, EntityNotFoundException, InvalidColumnException, InvalidRowException {
        EntitaEntity entitaEntityQuery = entitaService.get(nome);

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

            if(entitaJSON.get("riga") == riga && entitaJSON.get("colonna") == colonna)
                entitaJSON.put("nome",nome);
        }

        System.out.println(mappaJSON);

        CoordinateEntity coordinateEntity = new CoordinateEntity();

        coordinateEntity.setPrimaryKeyCoordinate(new CoordinateEntity.PrimaryKeyCoordinate(riga,colonna,entitaEntityQuery.getId()));
    }

    @Override
    @Transactional
    public void riempi(String mappa, List<String> nomi) {

    }
}
