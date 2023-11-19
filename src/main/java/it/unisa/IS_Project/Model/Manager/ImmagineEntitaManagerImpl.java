package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.ImmagineEntitaEntity;
import it.unisa.IS_Project.Model.Model.ImmagineEntitaModel;
import it.unisa.IS_Project.Model.Repository.ImmagineEntitaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImmagineEntitaManagerImpl implements ImmagineEntitaManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ImmagineEntitaRepository immagineEntitaRepository;

    @Override
    public ImmagineEntitaEntity save(ImmagineEntitaModel immagineEntitaModel) {
        ImmagineEntitaEntity immagineEntitaEntity=modelMapper.map(immagineEntitaModel,ImmagineEntitaEntity.class);
        return immagineEntitaRepository.save(immagineEntitaEntity);
    }

    @Override
    public ImmagineEntitaEntity get(int idImmagineEntita) {
        return immagineEntitaRepository.findAllByIdFoto(idImmagineEntita).orElseThrow(()->new RuntimeException("Foto non trovata"));
    }

    @Override
    public void delete(int idImmagineEntita) {
        if(immagineEntitaRepository.existsById(idImmagineEntita)){
            immagineEntitaRepository.deleteById(idImmagineEntita);
        }
    }
}
