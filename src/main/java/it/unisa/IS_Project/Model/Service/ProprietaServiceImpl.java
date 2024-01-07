package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import it.unisa.IS_Project.Exception.GEN.GEN.CreazioneEntita.InvalidPropertyNameException;
import it.unisa.IS_Project.Exception.GEN.GEN.CreazioneEntita.InvalidPropertyValueException;
import it.unisa.IS_Project.Exception.GEN.GEN.CreazioneEntita.NotUniquePropertyException;
import it.unisa.IS_Project.Exception.GEN.GEN.CreazioneEntita.PropertyNotFoundException;
import it.unisa.IS_Project.Model.Repository.ProprietaRepository;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietaServiceImpl implements ProprietaService {
    
    @Autowired
    private ProprietaRepository proprietaRepository;

    @Override
    @Transactional
    public void creaProprieta(String nome, String valore, EntitaEntity entitaEntity) throws InvalidPropertyNameException, InvalidPropertyValueException, NotUniquePropertyException {
        
        ProprietaEntity proprietaEntity = new ProprietaEntity();
        ProprietaEntity proprietaEntityQuery = proprietaRepository.findByNomeAndEntitaEntity(nome,entitaEntity);

        if(!Validator.isPropertyNameValid(nome))
            throw new InvalidPropertyNameException("ERRORE - NOME PROPRIETÀ NON VALIDO.");

        if(proprietaEntityQuery != null)
            throw new NotUniquePropertyException("ERRORE - PROPRIETÀ GIÀ ESISTENTE.");

        if(!Validator.isPropertyValueValid(valore))
            throw new InvalidPropertyValueException("ERRORE - VALORE PROPRIETÀ NON VALIDO.");

        proprietaEntity.setNome(nome);
        proprietaEntity.setValore(valore);
        proprietaEntity.setEntitaEntity(entitaEntity);

        proprietaRepository.save(proprietaEntity);
    }

    @Override
    @Transactional
    public void modificaProprieta(String nome, String valore, EntitaEntity entitaEntity) throws PropertyNotFoundException, InvalidPropertyNameException, InvalidPropertyValueException, NotUniquePropertyException {
        ProprietaEntity proprietaEntityQuery = proprietaRepository.findByNomeAndEntitaEntity(nome,entitaEntity);

        if(proprietaEntityQuery == null)
            throw new PropertyNotFoundException("ERRORE - PROPRIETÀ NON ESISTENTE.");

        proprietaRepository.delete(proprietaEntityQuery);

        creaProprieta(nome,valore,entitaEntity);
    }

    @Override
    @Transactional
    public List<ProprietaEntity> getLista(EntitaEntity entitaEntity) {
        return proprietaRepository.findAllByEntitaEntity(entitaEntity);
    }

    @Override
    @Transactional
    public void save(ProprietaEntity proprieta) {
        proprietaRepository.save(proprieta);
    }


}
