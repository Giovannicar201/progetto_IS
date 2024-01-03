package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.InvalidFolderNameException;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.NotUniqueFolderException;
import it.unisa.IS_Project.Model.Repository.CartellaRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartellaServiceImpl implements CartellaService{
    @Autowired
    private CartellaRepository cartellaRepository;
    @Autowired
    private UtenteService utenteService;


    @Override
    @Transactional
    public void creaCartella(String nomeCartella,String email) throws InvalidFolderNameException, NotUniqueFolderException {
        CartellaEntity cartellaEntity = new CartellaEntity();
        CartellaEntity cartellaEntityQuery = cartellaRepository.findByNome(nomeCartella);
        UtenteEntity utenteEntity = utenteService.get(email);

        if(Validator.isFolderNameValid(nomeCartella))
            throw new InvalidFolderNameException("ERRORE - NOME CARTELLA NON VALIDO.");

        if(cartellaEntityQuery != null)
            throw new NotUniqueFolderException("ERRORE - CARTELLA GIÀ ESISTENTE.");

        cartellaEntity.setNome(nomeCartella);
        cartellaEntity.setUtenteEntity(utenteEntity);

        cartellaRepository.save(cartellaEntity);
    }

    @Override
    @Transactional
    public String visualizzaListaCartelle(String email) {
        JSONObject cartelleJSON = new JSONObject();
        JSONArray nomiCartelle = new JSONArray();

        List<CartellaEntity> cartelle = cartellaRepository.findAllByEmail(email);

        for(CartellaEntity cartellaEntity : cartelle)
            nomiCartelle.add(cartellaEntity.getNome());

        cartelleJSON.put("nomiCartelle", nomiCartelle);

        return cartelleJSON.toString();
    }

    @Override
    @Transactional
    public CartellaEntity get(String nomeCartella) {
        return cartellaRepository.findByNome(nomeCartella);
    }

    @Override
    @Transactional
    public CartellaEntity update(CartellaEntity newCartellaEntity,String nomeCartella) {
        CartellaEntity cartellaEntity=cartellaRepository.findByNome(nomeCartella);
        newCartellaEntity.setNome(nomeCartella);
        cartellaEntity.setNome(newCartellaEntity.getNome());

        return cartellaRepository.save(cartellaEntity);
    }
}
