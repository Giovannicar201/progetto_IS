package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import it.unisa.IS_Project.Model.Model.ProprietaModel;
import it.unisa.IS_Project.Model.Repository.ProprietaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietaManagerImpl implements ProprietaManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProprietaRepository proprietaRepository;

    @Override
    public ProprietaEntity save(ProprietaModel proprietaModel) {
        ProprietaEntity proprietaEntity=modelMapper.map(proprietaModel,ProprietaEntity.class);
        return proprietaRepository.save(proprietaEntity);
    }

    @Override
    public ProprietaEntity get(String nomeProprieta) {
        return proprietaRepository.findAllById(nomeProprieta).orElseThrow(()->new RuntimeException("Proprietà non trovata"));
    }

    @Override
    public void delete(String nomeProprieta) {
        if(proprietaRepository.existsById(nomeProprieta)){
            proprietaRepository.deleteById(nomeProprieta);
        }
    }
}
