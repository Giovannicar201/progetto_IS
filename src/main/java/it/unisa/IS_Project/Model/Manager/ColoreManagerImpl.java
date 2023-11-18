package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.ColoreEntity;
import it.unisa.IS_Project.Model.Model.ColoreModel;
import it.unisa.IS_Project.Model.Repository.ColoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColoreManagerImpl implements ColoreManager{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ColoreRepository coloreRepository;

    @Override
    public ColoreEntity save(ColoreModel coloreModel) {
        ColoreEntity coloreEntity=modelMapper.map(coloreModel,ColoreEntity.class);
        return coloreRepository.save(coloreEntity);
    }

    @Override
    public ColoreEntity get(String esadecimale) {
        return coloreRepository.findColoreEntityByEsadecimale(esadecimale).orElseThrow(()->new RuntimeException("Colore non trovato"));
    }

    @Override
    public void delete(String esadecimale) {
        if(coloreRepository.existsById(esadecimale)){
            coloreRepository.deleteById(esadecimale);
        }
    }
}
