package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ColoreEntity;
import it.unisa.IS_Project.Model.Entity.PaletteEntity;
import it.unisa.IS_Project.Model.Model.ColoreModel;
import it.unisa.IS_Project.Model.Model.PaletteModel;
import it.unisa.IS_Project.Model.Repository.ColoreRepository;
import it.unisa.IS_Project.Model.Repository.PaletteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColoreServiceImpl implements ColoreService{
    @Autowired
    private ColoreRepository coloreRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PaletteRepository paletteRepository;
    
    @Override
    @Transactional
    public ColoreModel add(ColoreModel coloreModel) {
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(coloreModel.getEsadecimale(),coloreModel.getPaletteModel().getNomePalette());
        ColoreEntity coloreEntity= modelMapper.map(coloreModel,ColoreEntity.class);
        coloreEntity.setPrimaryKey(primaryKey);
        coloreRepository.save(coloreEntity);
        return modelMapper.map(coloreEntity,ColoreModel.class);
    }

    @Override
    @Transactional
    public ColoreModel add2(ColoreModel coloreModel,String esadecimale,String nomePalette){
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(esadecimale,nomePalette);
        ColoreEntity coloreEntity=modelMapper.map(coloreModel,ColoreEntity.class);
        primaryKey.setEsadecimale(esadecimale);
        primaryKey.setNomePalette(nomePalette);
        coloreEntity.setPrimaryKey(primaryKey);

        PaletteEntity paletteEntity=paletteRepository.findByNomePalette(nomePalette);
        paletteEntity.setNomePalette(nomePalette);

        coloreEntity.setNomePaletteEntity(paletteEntity);
        coloreRepository.save(coloreEntity);
        return modelMapper.map(coloreEntity,ColoreModel.class);
    }

    @Override
    @Transactional
    public ColoreModel get(String esadecimale, String nomePalette) {
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(esadecimale,nomePalette);
        ColoreEntity coloreEntity=coloreRepository.findById(primaryKey).orElse(null);
        return modelMapper.map(coloreEntity,ColoreModel.class);
    }

    @Override
    @Transactional
    public ColoreModel update(ColoreModel newColoreModel,String esadecimale,String nomePalette) {
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(esadecimale,nomePalette);
        ColoreEntity coloreEntity=coloreRepository.findById(primaryKey).orElse(null);

        newColoreModel.setEsadecimale(esadecimale);

        newColoreModel.getPaletteModel().setNomePalette(nomePalette);

        coloreEntity.setNomePaletteEntity(modelMapper.map(newColoreModel.getPaletteModel(), PaletteEntity.class));
        ColoreEntity saved=coloreRepository.save(coloreEntity);
        return modelMapper.map(saved,ColoreModel.class);
    }

    @Override
    @Transactional
    public void delete(String esadecimale, String nomePalette) {
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(esadecimale,nomePalette);
        coloreRepository.deleteById(primaryKey);
    }
}
