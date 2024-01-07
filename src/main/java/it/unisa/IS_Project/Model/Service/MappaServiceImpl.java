package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapHeightException;
import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapNameException;
import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapWidthException;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappaServiceImpl implements MappaService {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private MappaRepository mappaRepository;

    @Override
    @Transactional
    public String creaMappa(String email, String nome, String altezza, String larghezza) throws InvalidMapNameException, InvalidMapWidthException, InvalidMapHeightException {

        UtenteEntity utenteEntity = utenteService.get(email);

        MappaEntity mappaEntity = new MappaEntity();
        
        mappaRepository.delete();
        
        long larghezzaLong = Long.parseLong(larghezza);
        long altezzaLong = Long.parseLong(altezza);

        if(!Validator.isMapNameValid(nome))
            throw new InvalidMapNameException("ERRORE - NOME NON VALIDO.");

        if(!Validator.isMapWidthValid(larghezzaLong))
            throw new InvalidMapWidthException("ERRORE - LARGHEZZA NON VALIDA.");

        if(!Validator.isMapHeightValid(altezzaLong))
            throw new InvalidMapHeightException("ERRORE - ALTEZZA NON VALIDA.");

        mappaEntity.setNome(nome);
        mappaEntity.setLarghezza(larghezzaLong);
        mappaEntity.setAltezza(altezzaLong);
        mappaEntity.setUtenteEntity(utenteEntity);

        JSONObject mappaJSON = new JSONObject();
        JSONArray entita = new JSONArray();

        for(int riga = 0; riga < larghezzaLong; riga++) {
            for (int colonna = 0; colonna < altezzaLong; colonna++) {
                
                JSONObject entitaJSON = new JSONObject();

                entitaJSON.put("id",0);
                entitaJSON.put("riga",riga + "");
                entitaJSON.put("colonna",colonna + "");
                entitaJSON.put("immagine","");

                entita.add(entitaJSON);
                
            }
        }

        mappaJSON.put("mappa",entita);

        mappaRepository.save(mappaEntity);

        return mappaJSON.toString();
    }

    @Override
    @Transactional
    public String visualizzaStatisticheMappa(String mappa) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject statistiche = new JSONObject();

        JSONObject mappaJSON = (JSONObject) parser.parse(mappa);
        JSONArray mappaArray = (JSONArray) mappaJSON.get("mappa");

        JSONObject entita = (JSONObject) mappaArray.get(mappaArray.size() - 1);

        String altezza = ((Long) entita.get("riga") + 1) + " ";
        String larghezza = ((Long) entita.get("colonna") + 1) + " ";

        //#entitapiazzate
        //#entitapiazzate%
        //cellevuote
        //cellevuote%
        //#eventi

        return statistiche.toString();
    }

    @Override
    @Transactional
    public MappaEntity update(MappaEntity newMappaEntity, String nomeMappa) {
        return null;
    }

    @Override
    public MappaEntity get(String email) {

        UtenteEntity utenteEntity = utenteService.get(email);

        return mappaRepository.findByUtenteEntity(utenteEntity);
    }
}
