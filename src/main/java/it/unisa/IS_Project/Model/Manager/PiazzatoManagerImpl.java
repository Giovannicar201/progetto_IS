package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.PiazzatoEntity;
import it.unisa.IS_Project.Model.Model.PiazzatoModel;
import it.unisa.IS_Project.Model.Repository.PiazzatoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiazzatoManagerImpl implements PiazzatoManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PiazzatoRepository piazzatoRepository;

    @Override
    public PiazzatoEntity save(PiazzatoModel piazzatoModel) {
        PiazzatoEntity.PrimaryKey primaryKey=new PiazzatoEntity.PrimaryKey(piazzatoModel.getIdMappaPiazzato().getId(),piazzatoModel.getIdEntitaPiazzato().getIdEntita(),piazzatoModel.getCordinate());
        PiazzatoEntity piazzatoEntity=modelMapper.map(piazzatoModel,PiazzatoEntity.class);
        piazzatoEntity.setPrimaryKey(primaryKey);
        return piazzatoRepository.save(piazzatoEntity);
    }

    @Override
    public PiazzatoEntity get(int idMappa, int idEntita, String coordinate) {
        return piazzatoRepository.findById(new PiazzatoEntity.PrimaryKey(idMappa,idEntita,coordinate)).orElseThrow(()->new RuntimeException("Piazzato non trovato"));
    }

    @Override
    public void delete(int idMappa, int idEntita, String coordinate) {
        PiazzatoEntity.PrimaryKey primaryKey=new PiazzatoEntity.PrimaryKey(idMappa,idEntita,coordinate);
        if(piazzatoRepository.existsById(primaryKey)){
            piazzatoRepository.deleteById(primaryKey);
        }
    }
}
