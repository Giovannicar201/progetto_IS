package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import it.unisa.IS_Project.Model.Model.ProprietaModel;
import it.unisa.IS_Project.Model.Repository.ProprietaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietaManagerImpl implements ProprietaManager{
    private final ModelMapper modelMapper;
    private final ProprietaRepository proprietaRepository;

    public ProprietaManagerImpl(ModelMapper modelMapper, ProprietaRepository proprietaRepository) {
        this.modelMapper = modelMapper;
        this.proprietaRepository = proprietaRepository;
    }

    @Override
    public ProprietaEntity save(ProprietaModel proprietaModel) {
        ProprietaEntity proprietaEntity=modelMapper.map(proprietaModel,ProprietaEntity.class);
        return proprietaRepository.save(proprietaEntity);
    }

    @Override
    public ProprietaEntity get(String nomeProprieta) {
        return proprietaRepository.findAllByNome(nomeProprieta).orElseThrow(()->new RuntimeException("Proprietà non trovata"));
    }

    @Override
    public void delete(String nomeProprieta) {
        if(proprietaRepository.existsById(nomeProprieta)){
            proprietaRepository.deleteById(nomeProprieta);
        }
    }
}
