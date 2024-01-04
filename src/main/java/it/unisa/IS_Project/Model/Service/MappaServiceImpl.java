package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Exception.GMP.GMP.CreazioneMappa.InvalidMapHeightException;
import it.unisa.IS_Project.Model.Exception.GMP.GMP.CreazioneMappa.InvalidMapNameException;
import it.unisa.IS_Project.Model.Exception.GMP.GMP.CreazioneMappa.InvalidMapWidthException;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MappaServiceImpl implements MappaService{
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private MappaRepository mappaRepository;

    @Override
    @Transactional
    public String creaMappa(String email, String nome, int altezza, int larghezza) throws InvalidMapNameException, InvalidMapWidthException, InvalidMapHeightException {
        MappaEntity mappaEntity = new MappaEntity();
        MappaEntity mappaEntityQuery = mappaRepository.findByNome(nome);
        UtenteEntity utenteEntity = utenteService.get(email);

        if(mappaEntityQuery != null)
            mappaRepository.delete(mappaEntityQuery);

        if(!Validator.isMapNameValid(nome))
            throw new InvalidMapNameException("ERRORE - NOME NON VALIDO.");

        if(!Validator.isMapWidthValid(larghezza))
            throw new InvalidMapWidthException("ERRORE - LARGHEZZA NON VALIDA.");

        if(!Validator.isMapHeightValid(altezza))
            throw new InvalidMapHeightException("ERRORE - ALTEZZA NON VALIDA.");

        mappaEntity.setNome(nome);
        mappaEntity.setLarghezza(larghezza);
        mappaEntity.setLunghezza(altezza);
        //mappaEntity.setUtenteEntity(utenteEntity);

        mappaRepository.save(mappaEntity);

        JSONObject mappaJSON = new JSONObject();
        JSONArray entita = new JSONArray();

        for(int riga = 0; riga < larghezza; riga++)
            for(int colonna = 0; colonna < altezza; colonna++) {
                JSONObject entitaJSON = new JSONObject();

                entitaJSON.put("id",0);
                entitaJSON.put("riga",riga);
                entitaJSON.put("colonna",colonna);

                entita.add(entitaJSON);
            }

        mappaJSON.put("mappa",entita);

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
    @Scheduled(fixedRate = 30000)
    public MappaEntity update(MappaEntity newMappaEntity, String nomeMappa) {
        MappaEntity mappaEntity=mappaRepository.findByNome(nomeMappa);
        newMappaEntity.setNome(nomeMappa);
        mappaEntity.setNome(newMappaEntity.getNome());
        mappaEntity.setLunghezza(newMappaEntity.getLunghezza());
        mappaEntity.setLarghezza(newMappaEntity.getLarghezza());
        MappaEntity saved=mappaRepository.save(mappaEntity);
        return saved;
    }
}
