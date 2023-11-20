package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.TilesetCustomEntity;
import it.unisa.IS_Project.Model.Model.TilesetCustomModel;
import it.unisa.IS_Project.Model.Repository.TilesetCustomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TilesetCustomManagerImpl implements TIlesetCustomManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TilesetCustomRepository tilesetCustomRepository;


    @Override
    public TilesetCustomEntity save(TilesetCustomModel tilesetCustomModel) {
        TilesetCustomEntity tilesetCustomEntity=modelMapper.map(tilesetCustomModel,TilesetCustomEntity.class);
        return tilesetCustomRepository.save(tilesetCustomEntity);
    }

    @Override
    public TilesetCustomEntity get(int idTilesetCustom) {
        return tilesetCustomRepository.findAllById(idTilesetCustom).orElseThrow(()->new RuntimeException("Tileset Custom non trovato"));
    }

    @Override
    public void delete(int idTilesetCustom) {
        if(tilesetCustomRepository.existsById(idTilesetCustom)){
          tilesetCustomRepository.deleteById(idTilesetCustom);
        }
    }
}
