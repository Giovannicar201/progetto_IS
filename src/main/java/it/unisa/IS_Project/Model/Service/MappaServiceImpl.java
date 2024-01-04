package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
    public String creaMappa(String email, String nome, int lunghezza, int larghezza) {
        MappaEntity mappaEntity = new MappaEntity();
        MappaEntity mappaEntityQuery = mappaRepository.findByNome(nome);
        UtenteEntity utenteEntity = utenteService.get(email);

        /*if(mappaEntityQuery != null)
          //  mappaRepository. //non posso cancellarla altrimenti mi cancella tutte le entity ecc

        if(!Validator.isMapNameValid())
            throw new InvalidMapNameException("ERRORE - NOME NON VALIDO.");

        if(!Validator.isMapWidthValid())
            throw new InvalidMapWidthException("ERRORE - LARGHEZZA NON VALIDA.");

        if(!Validator.isMapHeigthValid())
            throw new InvalidMapHeightException("ERRORE - ALTEZZA NON VALIDA.");

        mappaEntity.setNome(nome);
        mappaEntity.setLarghezza(larghezza);
        mappaEntity.setLunghezza(lunghezza);
        mappaEntity.setIdMappaUtente(utenteEntity); //perchè si chiama idmappautente

        mappaRepository.save(mappaEntity);

        JSONObject mappaJSON = new JSONObject();
        JSONArray entita = new JSONArray();

        mappaJSON.put("mappa",entita);

        return mappaJSON.toString();*/

        return null;

    }

    @Override
    public String visualizzaStatisticheMappa(String email) {
        return null;
    }

    @Override
    public MappaEntity get(String nome) {
        return null;
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
