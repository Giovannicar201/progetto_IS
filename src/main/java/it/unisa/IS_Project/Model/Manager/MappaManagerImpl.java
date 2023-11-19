package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Model.MappaModel;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappaManagerImpl implements MappaManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MappaRepository mappaRepository;

    @Override
    public MappaEntity save(MappaModel mappaModel) {
        MappaEntity mappaEntity=modelMapper.map(mappaModel,MappaEntity.class);
        return mappaRepository.save(mappaEntity);
    }

    @Override
    public MappaEntity get(int idMappa) {
        return mappaRepository.findById(idMappa).orElseThrow(()->new RuntimeException("Mappa non trovata"));
    }

    @Override
    public void delete(int idMappa) {
        if(mappaRepository.existsById(idMappa)){
            mappaRepository.deleteById(idMappa);
        }
    }
}
