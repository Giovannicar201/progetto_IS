package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Model.MappaModel;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappaServiceImpl implements MappaService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MappaRepository mappaRepository;

    @Override
    @Transactional
    public MappaModel add(MappaModel mappaModel) {
        MappaEntity mappaEntity=modelMapper.map(mappaModel,MappaEntity.class);
        mappaRepository.save(mappaEntity);
        return modelMapper.map(mappaEntity, MappaModel.class);
    }

    @Override
    @Transactional
    public MappaModel get(int idMappa) {
        MappaEntity mappaEntity=mappaRepository.findById(idMappa).get();
        return modelMapper.map(mappaEntity, MappaModel.class);
    }

    @Override
    @Transactional
    public MappaModel update(MappaModel newMappaModel, int idMappa) {
        MappaEntity mappaEntity=mappaRepository.findById(idMappa).get();
        newMappaModel.setId(idMappa);
        mappaEntity.setNome(newMappaModel.getNome());
        mappaEntity.setLunghezza(newMappaModel.getLunghezza());
        mappaEntity.setLarghezza(newMappaModel.getLarghezza());
        MappaEntity saved=mappaRepository.save(mappaEntity);
        return modelMapper.map(mappaEntity, MappaModel.class);
    }

    @Override
    @Transactional
    public void delete(int idMappa) {
        mappaRepository.deleteById(idMappa);
    }
}
