package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Model.EntitaModel;
import it.unisa.IS_Project.Model.Repository.EntitaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntitaServiceImpl implements EntitaService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntitaRepository entitaRepository;

    @Override
    @Transactional
    public EntitaModel add(EntitaModel entitaModel) {
        EntitaEntity entitaEntity=modelMapper.map(entitaModel,EntitaEntity.class);
        entitaRepository.save(entitaEntity);
        return modelMapper.map(entitaEntity,EntitaModel.class);
    }

    @Override
    @Transactional
    public EntitaModel get(int idEntita) {
        EntitaEntity entitaEntity=entitaRepository.findAllById(idEntita).orElse(null);
        return modelMapper.map(entitaEntity, EntitaModel.class);
    }

    @Override
    @Transactional
    public EntitaModel update(EntitaModel newEntitaModel, int idEntita) {
        EntitaEntity entitaEntity=entitaRepository.findAllById(idEntita).orElse(null);
        newEntitaModel.setIdEntita(idEntita);
        entitaEntity.setNome(newEntitaModel.getNome());
        entitaEntity.setCollisione(newEntitaModel.getCollisione());
        EntitaEntity saved=entitaRepository.save(entitaEntity);
        return modelMapper.map(saved, EntitaModel.class);
    }

    @Override
    @Transactional
    public void delete(int idEntita) {
        entitaRepository.deleteById(idEntita);
    }

    @Override
    @Transactional
    public List<EntitaModel> findAllEntity(int idCartella){
        List<EntitaEntity> entitaEntities=entitaRepository.findAllByCartellaEntity(idCartella);

        return entitaEntities.stream().map((entita)->modelMapper.map(entita,EntitaModel.class)).collect(Collectors.toList());
    }
}
