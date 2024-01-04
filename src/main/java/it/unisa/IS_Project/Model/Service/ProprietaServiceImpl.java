package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.InvalidPropertyNameException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.InvalidPropertyValueException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.NotUniquePropertyException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.PropertyNotFoundException;
import it.unisa.IS_Project.Model.Repository.ProprietaRepository;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietaServiceImpl implements ProprietaService{
    @Autowired
    private ProprietaRepository proprietaRepository;

    @Override
    @Transactional
    public void creaProprieta(String nomeProprieta, String valoreProprieta, EntitaEntity entita) throws InvalidPropertyNameException, InvalidPropertyValueException, NotUniquePropertyException {
        ProprietaEntity proprietaEntity = new ProprietaEntity();
        ProprietaEntity proprietaEntityQuery = proprietaRepository.findByNome(nomeProprieta);

        if(!Validator.isPropertyNameValid(nomeProprieta))
            throw new InvalidPropertyNameException("ERRORE - NOME PROPRIETÀ NON VALIDO.");

        if(proprietaEntityQuery != null)
            throw new NotUniquePropertyException("ERRORE - PROPRIETÀ GIÀ ESISTENTE.");

        if(!Validator.isPropertyValueValid(valoreProprieta))
            throw new InvalidPropertyValueException("ERRORE - VALORE PROPRIETÀ NON VALIDO.");

        proprietaEntity.setNome(nomeProprieta);
        proprietaEntity.setValore(valoreProprieta);
        proprietaEntity.setEntitaEntity(entita);

        proprietaRepository.save(proprietaEntity);
    }

    @Override
    @Transactional
    public void modificaProprieta(String nomeProprieta, String valoreProprieta, EntitaEntity entita) throws PropertyNotFoundException, InvalidPropertyNameException, InvalidPropertyValueException, NotUniquePropertyException {
        ProprietaEntity proprietaEntityQuery = proprietaRepository.findByNome(nomeProprieta);

        if(proprietaEntityQuery == null)
            throw new PropertyNotFoundException("ERRORE - PROPRIETÀ NON ESISTENTE.");

        proprietaRepository.delete(proprietaEntityQuery);

        creaProprieta(nomeProprieta,valoreProprieta,entita);
    }

    @Override
    @Transactional
    public List<ProprietaEntity> getLista(EntitaEntity entita) {
        return proprietaRepository.findAllByEntita(entita);
    }
}
