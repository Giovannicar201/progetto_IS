package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Model.EntitaModel;
import it.unisa.IS_Project.Model.Repository.EntitaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntitaManagerImpl implements EntitaManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntitaRepository entitaRepository;

    @Override
    public EntitaEntity save(EntitaModel entitaModel) {
        EntitaEntity entitaEntity=modelMapper.map(entitaModel,EntitaEntity.class);
        return entitaRepository.save(entitaEntity);
    }

    @Override
    public EntitaEntity get(int idEntita) {
        return entitaRepository.findAllById(idEntita).orElseThrow(()->new RuntimeException("Entità non trovata"));
    }

    @Override
    public void delete(int idEntita) {
        if(entitaRepository.existsById(idEntita)){
            entitaRepository.deleteById(idEntita);
        }
    }
}
